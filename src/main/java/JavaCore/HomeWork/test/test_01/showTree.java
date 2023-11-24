package JavaCore.HomeWork.test.test_01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class showTree {
    public static void main(String[] args) {
        // printTree(new File("src"), "", true);

        File sourceDir = new File("src");
        File backupDir = new File("./backup3");

        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        backup(sourceDir, backupDir);


    }

    public static void printTree(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("|__");
            indent += "   ";
        } else {
            System.out.print("|--");
            indent += "|  ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();

        if (files == null) {
            return;
        }

        int subDirCount = 0;
        for (int i = 0; i < files.length; i++) {
            subDirCount++;
        }

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirTotal++;
                printTree(files[i], indent, subDirCount == subDirTotal);
            } else {
                printTree(files[i], indent, subDirCount == subDirTotal);
            }
        }

    }

    public static void backup(File sourceDir, File backupDir) {
        File[] files = sourceDir.listFiles();

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    File newDir = new File(backupDir, files[i].getName());
                    newDir.mkdir();
                    backup(files[i], newDir);
                } else {
                    File newFile = new File(backupDir, files[i].getName());
                    try {
                        copy(files[i], newFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void copy(File backupDir, File newFile) throws IOException {
        Path sourse = backupDir.toPath();
        Path newDir = newFile.toPath();
        Files.copy(sourse, newDir, StandardCopyOption.REPLACE_EXISTING);
    }

}
