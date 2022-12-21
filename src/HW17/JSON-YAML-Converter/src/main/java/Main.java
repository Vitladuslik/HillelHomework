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

    private static String fileName;

    private static String tempFileName = "MOCK_DATA.json";

    public static void main(String[] args) throws IOException {

        ConverterImpl service = new ConverterImpl();

        File startPath = new File(tempPath);

        boolean working = true;
        while (working) {
            System.out.println("Current working directory is : " + tempPath);
            System.out.println("Choose file to convert or press '0' to exit : ");
            service.viewContents(startPath);
            Scanner scan = new Scanner(System.in);
//            try {
//                fileName = scan.nextLine();
//                if (fileName.equals("0")) {
//                    System.out.println("Shutting down...");
//                    working = false;
//                }
//            } catch (InputMismatchException e) {
//                System.err.println("Wrong input!");
//                working = false;
//            }
            File[] listFiles = startPath.listFiles();
            assert listFiles != null;

            int counter = 1;
            Map<Integer, String> files = new HashMap<>();
            for (File f : listFiles) {
                files.put(counter, f.getName());
                counter++;
            }

            int choice = scan.nextInt();

            for (File f : listFiles) {
                if (f.getName().equals(files.get(choice))) {
                    service.setOldFileName(f.getName());
                    service.setOldFileSize(Files.size(Paths.get(f.getAbsolutePath())));
                }
            }

            switch (service.checkFormat(tempPath + "\\" + files.get(choice))) {
                case "JSON" -> {
                    service.convertToYaml(tempPath + "\\" + files.get(choice));
                    working = false;
                }
                case "YAML" -> {
                    service.convertToJson(tempPath + "\\" + fileName);
                    working = false;
                }
                default -> {
                    System.out.println("Cannot convert selected file!");
                    working = false;
                }
            }

            service.write(tempPath);

        }

    }

}
