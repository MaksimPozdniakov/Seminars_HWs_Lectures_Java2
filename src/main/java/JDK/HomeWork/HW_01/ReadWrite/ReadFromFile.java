package JDK.HomeWork.HW_01.ReadWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFile {
    private String path;

    public ReadFromFile(String path) {
        this.path = path;
    }

    public ArrayList<String> read(ArrayList<String> storyDialogs) throws FileNotFoundException {
        Scanner s = new Scanner(new File(path));
        while (s.hasNextLine()) {
            storyDialogs.add(s.nextLine());
        }
        s.close();
        return storyDialogs;
    }
}
