import hillel.FileWriter;
import hillel.impl.FileWriterImpl;
import hillel.impl.ServiceImpl;
import hillel.impl.ToJsonConverterImpl;
import hillel.impl.ToYamlConverterImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Run {

    public static void main(String[] args) throws IOException {

        ServiceImpl service = new ServiceImpl();

        ToJsonConverterImpl jsonConverter = new ToJsonConverterImpl();
        ToYamlConverterImpl yamlConverter = new ToYamlConverterImpl();

        FileWriter saver = new FileWriterImpl();

        Path path = Path.of(System.getProperty("user.dir"));

        if (args.length > 0) {
            path = Path.of(args[0]);
        }


        File startPath = new File(path.toUri());

        System.out.println("Current working directory is : " + path);

        File[] allFiles = startPath.listFiles();
        assert allFiles != null;

        ArrayList<File> filesToConvert = new ArrayList<>();

        for (File f : allFiles) {
            if (f.getName().toLowerCase().endsWith("yaml") || f.getName().toLowerCase().endsWith("json")) {
                filesToConvert.add(f);
            }
        }

        if (filesToConvert.size() == 0) {
            System.out.println("No files to convert!");
            saver.write(Paths.get("").toAbsolutePath(), null, service);
            System.exit(0);
        }

        for (File file : filesToConvert) {

            switch (service.checkFormat(file.getPath())) {
                case "JSON" -> {
                    yamlConverter.convertToYaml(file, service);
                    saver.write(path, service.getResult(), service);
                }

                case "YAML" -> {
                    jsonConverter.convertToJson(file, service);
                    saver.write(path, service.getResult(), service);
                }
            }
        }


    }
}
