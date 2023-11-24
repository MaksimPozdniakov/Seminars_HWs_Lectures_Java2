package JavaCore.HomeWork.HW_05;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ScanAndClone {
    public static void main(String[] args) {
        showTree(new File("src"), "", true);

        File sourceDirectory = new File("src");
        File backupDirectory = new File("./backup");
        if (!backupDirectory.exists()) {
            backupDirectory.mkdir();
        }

        System.out.println();

        ScanAndCloneDir(sourceDirectory, backupDirectory);
        System.out.println("Резервная копия создана!");


    }

    public static void showTree(File file, String indent, boolean isLast) {
        System.out.print(indent);

        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();

        if (files == null) {
            return;
        }

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirTotal++;
            }
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirCounter++;
                showTree(files[i], indent, subDirCounter == subDirTotal);
            } else {
                if (files[i].isFile()) {
                    showTree(files[i], indent, subDirCounter == subDirTotal);
                }
            }
        }
    }

    public static void ScanAndCloneDir(File sourceDirectory, File backupDirectory) {

        File[] files = sourceDirectory.listFiles();

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    File newBackupDir = new File(backupDirectory, files[i].getName());
                    newBackupDir.mkdir();
                    ScanAndCloneDir(files[i], newBackupDir);
                } else {
                    File backupFile = new File(backupDirectory, files[i].getName());
                    try {
                        copyFile(files[i], backupFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // метод копирования содержимого одного файла (source) в другой (dest) с заменой
    private static void copyFile(File source, File dest) throws IOException {
        Path sourcePath = source.toPath();
        Path destPath = dest.toPath();
        Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
    }

}