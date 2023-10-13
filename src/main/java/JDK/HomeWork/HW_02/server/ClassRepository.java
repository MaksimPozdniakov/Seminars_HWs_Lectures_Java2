package JDK.HomeWork.HW_02.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassRepository implements ServerRepositoryInterface{

    private String path;

    public ClassRepository(String path) {
        this.path = path;
    }

    @Override
    public ArrayList<String> readFromFile(ArrayList<String> log) {
        try {
            Scanner s = new Scanner(new File(path));
            while (s.hasNextLine()) {
                log.add(s.nextLine());
            }
            s.close();
        } catch (IOException e) {
            // Обработка исключения, например, вывод сообщения об ошибке.
            System.err.println("Произошла ошибка при чтении файла: " + e.getMessage());
        }
        return log;
    }

    @Override
    public void writeToFile(ArrayList<String> log) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string: log) {
            if (!stringBuilder.isEmpty()) stringBuilder.append("\n");
            stringBuilder.append(string);
        }

        try (FileWriter fw = new FileWriter(path, false)) {
            fw.append(stringBuilder);
            fw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
