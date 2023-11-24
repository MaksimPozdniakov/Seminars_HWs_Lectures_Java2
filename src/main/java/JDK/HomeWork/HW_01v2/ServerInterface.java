package JDK.HomeWork.HW_01v2;

import JDK.HomeWork.HW_01.ReadWrite.ReadFromFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ServerInterface extends JFrame {
    private static final int WIDTH = 555;
    private static final int HEIGHT = 555;
    private JButton jbStart, jbStop;
    private JTextArea jTextArea;
    private JPanel mainMenu;
    private boolean flag = false;
    private static ArrayList<String> storyDialogs = new ArrayList<>();

    private ReadFromFile readFromFile = new ReadFromFile(
            "src/main/java/JDK/HomeWork/HW_01/ReadWrite/Log.txt");

    public ServerInterface() {
        jTextArea = new JTextArea();
        mainMenu = new JPanel(new GridLayout(1, 2));
        jbStart = new JButton("Start");
        jbStop = new JButton("Stop");
        mainMenu.add(jbStart);
        mainMenu.add(jbStop);

        add(jTextArea);
        add(mainMenu, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Server Interface");
        setResizable(false);
        setVisible(true);

        addListenerOnButton();
    }

    private void addListenerOnButton() {
        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("The server is running");
                flag = true;

                try {
                    printStoryDialog();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        jbStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("The server is stopped");
                flag = false;
                jTextArea.setText("");
            }
        });
    }

    public void printMessage(String string) {
        if (flag) {
            jTextArea.append(string + "\n");
        }
    }

    public void printStoryDialog() throws FileNotFoundException {
        storyDialogs.clear();
        readFromFile.read(storyDialogs);

        jTextArea.setText("");

        for (String storyDialog : storyDialogs) {
            jTextArea.append(storyDialog + "\n");
        }
    }

    // этот метод заменяет класс Main
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            ServerInterface server = new ServerInterface();
//            // Создаем клиентов и передаем им ссылку на сервер
//            ClientInterface client1 = new ClientInterface(server);
//            ClientInterface client2 = new ClientInterface(server);
//
//            // Открываем окна клиентов
//            client1.setVisible(true);
//            client2.setVisible(true);
//        });
//    }
}
