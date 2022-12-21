import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

public class Test {

    public static void main(String[] args) throws JsonProcessingException {

        String jsonPath = "C:\\Users\\Vitladuslik\\IdeaProjects\\HillelHomework\\src\\HW17\\JSON-YAML-Converter\\src\\main\\resources\\MOCK_DATA.json";

        String yamlPath = "C:\\Users\\Vitladuslik\\IdeaProjects\\HillelHomework\\src\\HW17\\JSON-YAML-Converter\\src\\main\\resources\\MOCK.yaml";

        String yamlStr = ReadFromFile.readToString(yamlPath);

        String jsonStr = ReadFromFile.readToString(jsonPath);

        System.out.println(yamlStr);

        System.out.println(isValidYaml(jsonStr));





    }


    public static void jsonSoloParse(String path) throws JsonSyntaxException {

        try {

            String json = ReadFromFile.readToString(path);

            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            Optional<JsonElement> jsonElement = Optional.ofNullable(jsonObject);

            if (jsonElement.isPresent()) {
                System.out.println(jsonElement.get());
            } else {
                System.out.println("Fail");
            }
        } catch (JsonSyntaxException e) {
            System.out.println("Not a valid Json!");
        }
    }

    public static void yamlParse(String path) {
        Yaml yaml = new Yaml();
        String yamlStr = ReadFromFile.readToString(path);
        System.out.println(yamlStr);
        Map<String, Object> obj = yaml.load(yamlStr);
//        System.out.println(obj);
        System.out.println(yaml.dump(obj));
    }

    public static void save() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String path = Paths.get("").toAbsolutePath().toString();

        try (FileWriter saver = new FileWriter(path + "\\result.log", true)) {
            System.out.println("Saving results to : " + path);
            saver.write(dtf.format(now) + " -> " + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isValidJson(String jsonStr) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonStr);
            return true;
        } catch (IOException e) {
            return false;
        }
    }


    public static boolean isValidYaml(String yamlStr) {
        try {
            Yaml yaml = new Yaml();
            yaml.load(yamlStr);
            Map<String, Object> obj = yaml.load(yamlStr);
            System.out.println("ok");
            return true;
        } catch (ClassCastException e) {
            System.out.println("not ok");
            return false;
        }
    }

    public static String convertYamlToJson(String yaml) throws JsonProcessingException {
        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Object obj = yamlReader.readValue(yaml, Object.class);

        ObjectMapper jsonWriter = new ObjectMapper();
        return jsonWriter.writeValueAsString(obj);
    }

    public String convertJsonToYaml(String jsonString) throws JsonProcessingException, IOException {
        // parse JSON
        JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonString);
        // save it as YAML
        return new YAMLMapper().writeValueAsString(jsonNodeTree);

    }
}
