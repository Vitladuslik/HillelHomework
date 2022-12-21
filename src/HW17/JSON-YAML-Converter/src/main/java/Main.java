import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

public class Main {

    public static void main(String[] args) {


        String st = "C:\\Users\\Vitladuslik\\IdeaProjects\\HillelHomework\\src\\HW17\\JSON-YAML-Converter\\src\\main\\resources\\example.yaml";

        yamlParse(st);

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

    public static boolean isValidJson(String json) {
        try {
            JsonParser.parseString(json);
        } catch (JsonSyntaxException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidYaml(String yamlStr) {
        try {
            Yaml yaml = new Yaml();
            yaml.load(yamlStr);
            Map<String, Object> obj = yaml.load(yamlStr);
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    String convertYamlToJson(String yaml) throws JsonProcessingException {
        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Object obj = yamlReader.readValue(yaml, Object.class);

        ObjectMapper jsonWriter = new ObjectMapper();
        return jsonWriter.writeValueAsString(obj);
    }

}
