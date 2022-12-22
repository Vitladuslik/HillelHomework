import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public interface Converter {

    String checkFormat(String filePath) throws IOException;

    boolean isValidYaml(String yamlStr);

    boolean isValidJson(String jsonStr);

    void convertToJson(File yamlFile) throws IOException;

    void convertToYaml(File jsonFile) throws IOException;

    void write(Path path, String result) throws IOException;

    String readToString(String filePath);

    String getResult();


}
