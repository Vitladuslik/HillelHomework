package hillel.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import hillel.Service;
import lombok.Getter;
import lombok.Setter;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Getter
@Setter

public class ServiceImpl implements Service {

    private String oldFileName;
    private long oldFileSize;
    private String newFileName;
    private long newFileSize;
    private boolean isOperationSuccessful = false;
    private String result;
    private long timeUsed;


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
