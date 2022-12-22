import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public interface Converter {

    String checkFormat(String filePath) throws IOException;

    void convertToJson(File yamlFile) throws IOException;

    void convertToYaml(File jsonFile) throws IOException;

    void write(Path path) throws IOException;


}
