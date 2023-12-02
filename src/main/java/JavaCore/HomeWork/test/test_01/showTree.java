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
        File backupDir = new File("./backup");

        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        ScanAndCloneDir(sourceDir,backupDir);

    }

    public static void printTree(File file, String indent, boolean isLast) {
        System.out.print(indent);

        if (isLast) {
            System.out.print("└─");
            indent += "   ";
        } else {
            System.out.print("├─");
            indent += "|   ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();

        if (files == null) {
            return;
        }

        int totalDir = 0;
        for (int i = 0; i < files.length; i++) {
            totalDir++;
        }

        int countDir = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                countDir++;
                printTree(files[i], indent, countDir == totalDir);
            } else {
                if (files[i].isFile()) {
                    printTree(files[i], indent, countDir == totalDir);
                }
            }
        }

    }

    public static void ScanAndCloneDir(File sourceDir, File backupDir) {
        File[] files = sourceDir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    File newDir = new File(backupDir, files[i].getName());
                    newDir.mkdir();
                    ScanAndCloneDir(files[i], newDir);
                } else {
                    if (files[i].isFile()) {
                        File newFile = new File(backupDir, files[i].getName());
                        try {
                            copyFiles(files[i], newFile);
                        } catch (IOException e) {
                            e.fillInStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static void copyFiles(File source, File dest) throws IOException {
        Path sourcePath = source.toPath();
        Path destPath = dest.toPath();
        Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
    }
}
