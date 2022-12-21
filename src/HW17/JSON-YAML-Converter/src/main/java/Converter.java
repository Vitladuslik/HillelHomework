import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface Converter {

    String checkFormat(String filePath) throws IOException;

    void convertToJson(String yamlFilePath) throws JsonProcessingException;

    void convertToYaml(String jsonFilePath) throws JsonProcessingException;

    void write(String path) throws IOException;


}
