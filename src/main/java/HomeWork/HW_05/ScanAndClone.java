package HomeWork.HW_05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScanAndClone {
    public static void main(String[] args) {
        showTree(new File("src"), "", true);

        File backupDirectory = new File("./backup");
        File sourceDirectory = new File("src");
        if (!backupDirectory.exists()) {
            backupDirectory.mkdir();
        }

        ScanAndCloneDir(sourceDirectory, backupDirectory);


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
                if (sourceDirectory.isDirectory()) {
                    File newBackupDir = new File(backupDirectory, files[i].getName());
                    newBackupDir.mkdir();
                    ScanAndCloneDir(files[i], newBackupDir);
                } else {
                    File backupFile = new File(backupDirectory, files[i].getName());
                    try {
                        Files.copy(files[i].toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Создана резервная копия: " + files[i].getAbsolutePath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}