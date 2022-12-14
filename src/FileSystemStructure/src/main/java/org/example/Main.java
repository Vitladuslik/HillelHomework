package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        File startPath = new File("C:\\Users\\Vitladuslik\\IdeaProjects\\HillelHomework\\src");

        viewContents(startPath);



    }

    public static void viewContents(File path) throws IOException {


        File[] listFiles = path.listFiles();
        assert listFiles != null;
        for (File f : listFiles) {
            if (!f.isHidden()) {
                if (f.isDirectory()) {
                    System.out.println("D -> " + f.getName() + "\n-------------------------------");
                    viewContents(f);
                } else {
                    long size = Files.size(Paths.get(f.getAbsolutePath()))/ 1024;
                    System.out.println("\tF -> " + f.getName() + " " + size + " kb");}
            }
        }

    }

}