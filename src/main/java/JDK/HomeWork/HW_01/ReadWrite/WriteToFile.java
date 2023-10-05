package JDK.HomeWork.HW_01.ReadWrite;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile {
    private String path;

    public WriteToFile(String path) {
        this.path = path;
    }

    public void write(ArrayList<String> storyDialogs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string: storyDialogs) {
            if (!stringBuilder.isEmpty()) stringBuilder.append("\n");
            stringBuilder.append(string);
        }

        try (FileWriter fw = new FileWriter(path, false)) {
            fw.append(stringBuilder);
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
