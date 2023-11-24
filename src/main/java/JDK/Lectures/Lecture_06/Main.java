package JDK.Lectures.Lecture_06;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().printFile();
    }

//    public void printFile() throws IOException {
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("file.txt");
//        System.out.println(new String(inputStream.readAllBytes()));
//    }
    public void printFile() throws IOException {
        String nameFile = "file.txt";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nameFile);

        ArrayList<String> storyDialogs = new ArrayList<>();
        if (inputStream != null) {
            Scanner s = new Scanner(inputStream);
            while (s.hasNextLine()) {
                storyDialogs.add(s.nextLine());
            }
            s.close();
        } else {
            System.err.println("Файл не найден: " + nameFile);
        }
        System.out.println(storyDialogs);
    }
}
