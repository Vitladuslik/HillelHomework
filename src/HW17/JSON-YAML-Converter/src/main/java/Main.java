import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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


        save();

    }


    public static void json_parse() {

        String jsonRaw = "{\"exchangeRate\":\"1650.0\"," +
                "\"externalPaymentDetails\":\"{" +
                "subscriberId=12054, " +
                "smartCardId=02124108694, " +
                "providerName=StarTimes," +
                " tvPackage=StarTimes, " +
                "expirationDate=2019-07-13}\"}";

        JsonObject jsonObject = JsonParser.parseString(jsonRaw).getAsJsonObject();

        Optional<JsonElement> jsonElement = Optional.ofNullable(jsonObject.get("exchangeRate"));

        if (jsonElement.isPresent()) {
            System.out.println(jsonElement.get().getAsString());
        } else {
            System.out.println();
        }

    }

    public static void yaml_parse() {
        Yaml yaml = new Yaml();
        String yamlStr = ReadFromFile.readToString(" !!!!!!!!!!");
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

}
