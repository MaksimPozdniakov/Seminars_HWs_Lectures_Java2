package JDK.Lectures.Test;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MapPanel mapPanel = new MapPanel();
        mapPanel.setFieldSize(3, 3); // Пример задания размера поля

        frame.add(mapPanel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
