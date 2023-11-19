package JDK.Lectures.Lecture_06;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().printFile();
    }

    public void printFile() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("file.txt");
        System.out.println(new String(inputStream.readAllBytes()));
    }
}
