package hillel;

import java.io.IOException;

public interface Service {

    String checkFormat(String filePath) throws IOException;

    boolean isValidYaml(String yamlStr);

    boolean isValidJson(String jsonStr);

    String readToString(String filePath);



}
