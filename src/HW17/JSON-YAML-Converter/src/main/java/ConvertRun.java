import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class ConvertRun {

    public static void main(String[] args) throws IOException {

        Path path = Path.of(System.getProperty("user.dir"));

        if (args.length > 0) {
            path = Path.of(args[0]);
        }


        ConverterImpl service = new ConverterImpl();

        File startPath = new File(path.toUri());

        System.out.println("Current working directory is : " + path);

        File[] allFiles = startPath.listFiles();
        assert allFiles != null;

        ArrayList<File> filesToConvert = new ArrayList<>();

        for (File f : allFiles) {
            if (f.getName().toLowerCase().endsWith("yaml") || f.getName().toLowerCase().endsWith("yaml")) {
                filesToConvert.add(f);
            }
        }

        for (File file : filesToConvert) {
            switch (service.checkFormat(file.getPath())) {
                case "JSON" -> service.convertToYaml(file);

                case "YAML" -> service.convertToJson(file);

                default -> System.out.println("Cannot convert selected file!");

            }
        }


        service.write(path);

    }

}
