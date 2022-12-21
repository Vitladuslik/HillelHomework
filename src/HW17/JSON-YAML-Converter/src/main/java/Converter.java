import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface Converter {

    String checkFormat(String filePath);

    void convertToJson(String yamlFilePath) throws JsonProcessingException;

    void convertToYaml(String jsonFilePath) throws JsonProcessingException;

    void write(String path) throws IOException;


}
