import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ConverterImplTest {

    @Test
    void isValidJson() {

        String testJsonPath = "C:\\Users\\Vitladuslik\\IdeaProjects\\HillelHomework\\src\\HW17\\JSON-YAML-Converter\\src\\main\\resources\\example.json";

        ConverterImpl testService = new ConverterImpl();

        String testStr = ReadFromFile.readToString(testJsonPath);

        Assertions.assertTrue(testService.isValidJson(testStr));

    }

    @Test
    void checkFormat() throws IOException {

        String testYamlPath = "C:\\Users\\Vitladuslik\\IdeaProjects\\HillelHomework\\src\\HW17\\JSON-YAML-Converter\\src\\main\\resources\\converted\\converted_example.yaml";

        String testJsonPath = "C:\\Users\\Vitladuslik\\IdeaProjects\\HillelHomework\\src\\HW17\\JSON-YAML-Converter\\src\\main\\resources\\example.json";

        ConverterImpl testService = new ConverterImpl();

        Assertions.assertEquals("JSON", testService.checkFormat(testJsonPath));
        Assertions.assertEquals("YAML", testService.checkFormat(testYamlPath));

    }

}
