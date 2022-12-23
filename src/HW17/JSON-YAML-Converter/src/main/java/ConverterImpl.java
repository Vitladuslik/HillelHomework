import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;


public class ConverterImpl implements Converter {

    private String oldFileName;
    private long oldFileSize;
    private String newFileName;
    private long newFileSize;
    boolean isOperationSuccessful = false;
    private String result;
    private long timeUsed;

    public void setOldFileName(String fileName) {
        this.oldFileName = fileName;
    }

    public void setOldFileSize(long fileSize) {
        this.oldFileSize = fileSize;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String checkFormat(String filePath) {

        String testStr = readToString(filePath);

        if (isValidJson(testStr)) {
            System.out.println("JSON detected");
            return "JSON";
        } else if (isValidYaml(testStr)) {
            System.out.println("YAML detected");
            return "YAML";
        } else {
            return null;
        }

    }

    @Override
    public void convertToJson(File yamlFile) throws IOException {

        oldFileName = yamlFile.getName();
        oldFileSize = Files.size(Paths.get(yamlFile.getPath()));

        long millisBefore = System.currentTimeMillis();

        String yamlStr = readToString(yamlFile.getPath());

        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Object obj = yamlReader.readValue(yamlStr, Object.class);

        ObjectMapper jsonWriter = new ObjectMapper();

        result = jsonWriter.writeValueAsString(obj);

        long millisAfter = System.currentTimeMillis();
        timeUsed = millisAfter - millisBefore;
        isOperationSuccessful = true;

        newFileName = "converted_" + oldFileName.split("\\.")[0] + ".json";

    }

    @Override
    public void convertToYaml(File jsonFile) throws IOException {

        long millisBefore = System.currentTimeMillis();

        setOldFileName(jsonFile.getName());
        setOldFileSize(Files.size(Path.of(jsonFile.getPath())));

        String jsonStr = readToString(jsonFile.getPath());

        JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonStr);

        result = new YAMLMapper().writeValueAsString(jsonNodeTree);

        long millisAfter = System.currentTimeMillis();
        timeUsed = millisAfter - millisBefore;

        isOperationSuccessful = true;

        newFileName = "converted_" + oldFileName.split("\\.")[0] + ".yaml";

    }

    @Override
    public void write(Path path, String result) throws IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        if (isOperationSuccessful) {
            File folder = new File(path +
                    File.separator + "convert");
            if (!folder.exists()) {
                folder.mkdir();
            }

            try (FileWriter saver = new FileWriter(folder + File.separator + newFileName)) {
                System.out.println("Saving converted file to : " + folder);
                saver.write(result);
            }

            File destinationFile = new File(folder + File.separator + newFileName);
            newFileSize = Files.size(Paths.get(destinationFile.getAbsolutePath()));
        }

        try (FileWriter saver = new FileWriter(path + "\\log.txt", true)) {
            System.out.println("Saving results to : " + path);
            if (isOperationSuccessful) {
                saver.write(dtf.format(now) + " -> " + "Converted " + oldFileName + " " + oldFileSize + " bytes to "
                        + newFileName + " " + newFileSize + " bytes in "
                        + timeUsed + " milliseconds." + "\n");
            } else {
                saver.write(dtf.format(now) + " -> operation was unsuccessful.\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean isValidJson(String jsonStr) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonStr);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean isValidYaml(String yamlStr) {

        Yaml yaml = new Yaml();
        yaml.load(yamlStr);
        return true;

    }

    @Override
    public String readToString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

}
