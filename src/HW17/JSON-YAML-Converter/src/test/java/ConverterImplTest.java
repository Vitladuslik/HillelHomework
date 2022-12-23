import hillel.Service;
import hillel.impl.ServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ConverterImplTest {

    @Test
    void isValidJson() {

        String testJsonPath = "C:\\Users\\Vitladuslik\\IdeaProjects\\HillelHomework\\MOCK_DATA.json";

        Service testService = new ServiceImpl();

        String testStr = testService.readToString(testJsonPath);

        Assertions.assertTrue(testService.isValidJson(testStr));

    }

    @Test
    void checkFormat() {

        String testYamlPath = "C:\\Users\\Vitladuslik\\IdeaProjects\\HillelHomework\\src\\HW17\\JSON-YAML-hillel.Converter\\src\\main\\resources\\example.yaml";

        String testJsonPath = "C:\\Users\\Vitladuslik\\IdeaProjects\\HillelHomework\\src\\HW17\\JSON-YAML-hillel.Converter\\src\\main\\resources\\example.json";

        ServiceImpl testService = new ServiceImpl();

        Assertions.assertEquals("JSON", testService.checkFormat(testJsonPath));
        Assertions.assertEquals("YAML", testService.checkFormat(testYamlPath));

    }

}
