import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static String workDir = Paths.get("").toAbsolutePath().toString();
    private static String tempPath = "C:\\Users\\Vitladuslik\\IdeaProjects\\HillelHomework\\src\\HW17\\JSON-YAML-Converter\\src\\main\\resources";
    private static int choice;

    public static void main(String[] args) throws IOException {

        ConverterImpl service = new ConverterImpl();

        File startPath = new File(tempPath);

        Scanner scan = new Scanner(System.in);

        System.out.println("Current working directory is : " + tempPath);
        System.out.println("Choose file to convert or enter any letter to exit : ");
        service.viewContents(startPath);

        File[] listFiles = startPath.listFiles();
        assert listFiles != null;

        int counter = 1;
        Map<Integer, String> files = new HashMap<>();

        for (File f : listFiles) {
            if (!f.isDirectory()) {
                files.put(counter, f.getName());
                counter++;
            }
        }

        try {
            choice = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Shutting down...");
        }

        for (File f : listFiles) {
            if (f.getName().equals(files.get(choice))) {
                service.setOldFileName(f.getName());
                service.setOldFileSize(Files.size(Paths.get(f.getAbsolutePath())));
            }
        }

        switch (service.checkFormat(tempPath + "\\" + files.get(choice))) {
            case "JSON" -> service.convertToYaml(tempPath + "\\" + files.get(choice));

            case "YAML" -> service.convertToJson(tempPath + "\\" + files.get(choice));

            default -> System.out.println("Cannot convert selected file!");

        }

        service.write(tempPath);

    }

}
