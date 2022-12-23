package hillel.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hillel.ToJsonConverter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ToJsonConverterImpl implements ToJsonConverter {

    public void convertToJson(File yamlFile, ServiceImpl service) throws IOException {

        service.setOldFileName(yamlFile.getName());
        service.setOldFileSize(Files.size(Paths.get(yamlFile.getPath())));

        long millisBefore = System.currentTimeMillis();

        String yamlStr = service.readToString(yamlFile.getPath());

        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Object obj = yamlReader.readValue(yamlStr, Object.class);

        ObjectMapper jsonWriter = new ObjectMapper();

        service.setResult(jsonWriter.writeValueAsString(obj));

        long millisAfter = System.currentTimeMillis();
        service.setTimeUsed(millisAfter - millisBefore);
        service.setOperationSuccessful(true);

        service.setNewFileName("converted_" + service.getOldFileName().split("\\.")[0] + ".json");

    }

}
