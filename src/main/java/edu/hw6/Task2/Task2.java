package edu.hw6.Task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {
    private Task2() {

    }

    public static boolean cloneFile(Path path) throws IOException {
        File file = path.toFile();
        if (file.isDirectory()) {
            return false;
        }

        String filePath = file.getPath();
        String extension = filePath.substring(filePath.lastIndexOf('.'));
        String fileNameNoExtension = filePath.substring(0, filePath.lastIndexOf('.'));

        int nextCopyNumber = 1;
        while (true) {
            StringBuilder newFileName = new StringBuilder(fileNameNoExtension);
            if (nextCopyNumber == 1) {
                newFileName.append(" - копия");
            } else {
                newFileName.append(String.format(" - копия (%d)", nextCopyNumber));
            }
            newFileName.append(extension);

            File newFile = new File(newFileName.toString());
            if (newFile.exists()) {
                nextCopyNumber++;
            } else {
                Files.copy(file.toPath(), newFile.toPath());
                break;
            }
        }

        return true;
    }
}
