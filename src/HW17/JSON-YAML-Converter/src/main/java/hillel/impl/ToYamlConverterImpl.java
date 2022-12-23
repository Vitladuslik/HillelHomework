package hillel.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hillel.ToYamlConverter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ToYamlConverterImpl implements ToYamlConverter {

    public void convertToYaml(File jsonFile, ServiceImpl service) throws IOException {

        long millisBefore = System.currentTimeMillis();

        service.setOldFileName((jsonFile.getName()));
        service.setOldFileSize(Files.size(Path.of(jsonFile.getPath())));

        String jsonStr = service.readToString(jsonFile.getPath());

        JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonStr);

        service.setResult(new YAMLMapper().writeValueAsString(jsonNodeTree));

        long millisAfter = System.currentTimeMillis();
        service.setTimeUsed(millisAfter - millisBefore);

        service.setOperationSuccessful(true);

        service.setNewFileName("converted_" + service.getOldFileName().split("\\.")[0] + ".yaml");

    }

}
