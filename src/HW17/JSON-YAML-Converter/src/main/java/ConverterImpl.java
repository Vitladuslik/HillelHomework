import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ConverterImpl implements Converter {

    String oldFileName;
    private long oldFileSize;
    String newFileName;
    private long newFileSize;
    boolean isOperationSuccessful = false;
    String result;
    long timeUsed;

    public void chooseFile() {

    }

    public void setOldFileName(String fileName) {
        this.oldFileName = fileName;
    }

    public void setOldFileSize(long fileSize) {
        this.oldFileSize = fileSize;
    }

    @Override
    public String checkFormat(String filePath) {

        String testStr = ReadFromFile.readToString(filePath);

        if (isValidJson(testStr)) {
            System.out.println("Selected file is JSON");
            return "JSON";
        } else if (isValidYaml(testStr)) {
            System.out.println("Selected file is YAML");
            return "YAML";
        } else {
            return null;
        }

    }

    @Override
    public void convertToJson(String yamlFilePath) throws JsonProcessingException {

        long millisBefore = System.currentTimeMillis() % 1000;

        String yamlStr = ReadFromFile.readToString(yamlFilePath);

        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Object obj = yamlReader.readValue(yamlStr, Object.class);

        ObjectMapper jsonWriter = new ObjectMapper();

        result = jsonWriter.writeValueAsString(obj);

        long millisAfter = System.currentTimeMillis() % 1000;
        timeUsed = millisAfter - millisBefore;
        isOperationSuccessful = true;
        System.out.println("Time in milliseconds used: " + timeUsed);

        newFileName = "converted_" + oldFileName + ".json";
//        newFileSize = Files.size(Paths.get(filePath.getAbsolutePath())) / 1024;

    }

    @Override
    public void convertToYaml(String jsonFilePath) throws JsonProcessingException {

        long millisBefore = System.currentTimeMillis() % 1000;

        String jsonStr = ReadFromFile.readToString(jsonFilePath);

        JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonStr);

        result = new YAMLMapper().writeValueAsString(jsonNodeTree);

        long millisAfter = System.currentTimeMillis() % 1000;
        timeUsed = millisAfter - millisBefore;
        isOperationSuccessful = true;
        System.out.println("Time in milliseconds used: " + timeUsed);
        newFileName = "converted_" + oldFileName + ".yaml";
        //        newFileSize = Files.size(Paths.get(filePath.getAbsolutePath())) / 1024;

    }

    @Override
    public void write(String path) throws IOException {

//        String workDir = Paths.get("").toAbsolutePath().toString();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        try (FileWriter saver = new FileWriter(path + "\\result.log", true)) {
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

        try (FileWriter saver = new FileWriter(path + "\\converted\\" + newFileName, true)) {
            System.out.println("Saving converted file to : " + path + "\\converted\\");
            saver.write(result);
        }
    }

    public boolean isValidJson(String jsonStr) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonStr);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean isValidYaml(String yamlStr) {


        return false;


    }

    public void viewContents(File path) throws IOException {

        File[] listFiles = path.listFiles();
        assert listFiles != null;
        int counter = 1;
        for (File f : listFiles) {
            if (!f.isHidden()) {
                if (!f.isDirectory()) {
                    long size = Files.size(Paths.get(f.getAbsolutePath())) / 1024;
                    System.out.println(counter + ") -> " + f.getName() + " " + size + " kb");
                    counter++;
                }
            }
        }

    }
}
