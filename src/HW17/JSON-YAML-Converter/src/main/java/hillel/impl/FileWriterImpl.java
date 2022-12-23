package hillel.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileWriterImpl implements hillel.FileWriter {

    public void write(Path path, String result, ServiceImpl service) throws IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        if (service.isOperationSuccessful()) {
            File folder = new File(path +
                    File.separator + "convert");
            if (!folder.exists()) {
                folder.mkdir();
            }

            try (FileWriter saver = new FileWriter(folder + File.separator + service.getNewFileName())) {
                System.out.println("Saving converted file to : " + folder);
                saver.write(result);
            }

            File destinationFile = new File(folder + File.separator + service.getNewFileName());
            service.setNewFileSize(Files.size(Paths.get(destinationFile.getAbsolutePath())));
        }

        try (FileWriter saver = new FileWriter(path + "\\log.txt", true)) {
            System.out.println("Saving results to : " + path);
            if (service.isOperationSuccessful()) {
                saver.write(dtf.format(now) + " -> " + "Converted " + service.getOldFileName() + " "
                        + service.getOldFileSize() + " bytes to "
                        + service.getNewFileName() + " " + service.getNewFileSize() + " bytes in "
                        + service.getTimeUsed() + " milliseconds." + "\n");
            } else {
                saver.write(dtf.format(now) + " -> operation was unsuccessful.\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
