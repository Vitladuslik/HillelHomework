import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ConvertRun {

    public static void main(String[] args) throws IOException {

        Path path = Path.of(System.getProperty("user.dir"));

        if (args.length > 0) {
            path = Path.of(args[0]);
        }

        Converter service = new ConverterImpl();

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

        if(filesToConvert.size() == 0) {
            System.out.println("No files to convert!");
            service.write(Paths.get("").toAbsolutePath(), null);
            System.exit(0);
        }
        
        for (File file : filesToConvert) {

            switch (service.checkFormat(file.getPath())) {
                case "JSON" -> {
                    service.convertToYaml(file);
                    service.write(path, service.getResult());
                }

                case "YAML" -> {
                    service.convertToJson(file);
                    service.write(path, service.getResult());
                }
            }
        }


    }
}
