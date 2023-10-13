package JDK.HomeWork.HW_01v2;

import JDK.HomeWork.HW_01.ReadWrite.ReadFromFile;
import JDK.HomeWork.HW_01.ReadWrite.WriteToFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ClientInterface extends JFrame {
    private static final int WIDTH = 555;
    private static final int HEIGHT = 555;

    private ServerInterface server;
    private static ArrayList<String> storyDialogs = new ArrayList<>();

    private WriteToFile writeToFile = new WriteToFile(
            "C:/Users/PMPav/OneDrive/Рабочий стол/Third block of study/Seminars/Seminars_HWs_Lectures_Java2/src" +
                    "/main/java/JDK/HomeWork/HW_01/ReadWrite/Log.txt");
    private ReadFromFile readFromFile = new ReadFromFile(
            "C:/Users/PMPav/OneDrive/Рабочий стол/Third block of study/Seminars/Seminars_HWs_Lectures_Java2/src" +
                    "/main/java/JDK/HomeWork/HW_01/ReadWrite/Log.txt");

    private JTextField textFieldMessage, textFieldIp, textFieldPort, textFieldLogin, textFieldPassword;
    private JButton inputButton, loginButton;
    private JPanel jpDown, jpUp;

    private String name;
    private String ip;
    private String port;

    public ClientInterface(ServerInterface server) {
        this.server = server;

        jpDown = new JPanel(new BorderLayout());
        textFieldMessage = new JTextField();
        inputButton = new JButton("Отправить");

        jpDown.add(textFieldMessage, BorderLayout.CENTER);
        jpDown.add(inputButton, BorderLayout.EAST);
        add(jpDown, BorderLayout.SOUTH);
        jpDown.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pack();

        textFieldIp = new JTextField();
        textFieldPort = new JTextField();
        textFieldIp.setPreferredSize(new Dimension(174, 30));
        textFieldPort.setPreferredSize(new Dimension(174, 30));

        textFieldLogin = new JTextField();
        textFieldPassword = new JTextField();
        loginButton = new JButton("Login");

        jpUp = new JPanel();
        jpUp.setLayout(new BoxLayout(jpUp, BoxLayout.Y_AXIS));

        JPanel firstRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        firstRow.add(textFieldIp);
        firstRow.add(textFieldPort);

        JPanel secondRow = new JPanel(new GridLayout(1, 3));
        secondRow.add(textFieldLogin);
        secondRow.add(textFieldPassword);
        secondRow.add(loginButton);

        jpUp.add(firstRow);
        jpUp.add(secondRow);

        add(jpUp, BorderLayout.NORTH);
        jpUp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Client Interface");
        setResizable(false);
        setVisible(true);

        addListenerOnButton();
    }

    private void addListenerOnButton() {
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!name.isEmpty() && !ip.isEmpty() && !port.isEmpty()) {
                    String fullName = "(" + ip + " : " + port + ") " + name + ": ";
                    String text = fullName + textFieldMessage.getText();

                    storyDialogs.clear();

                    try {
                        readFromFile.read(storyDialogs);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                    storyDialogs.add(text);
                    writeToFile.write(storyDialogs);

                    server.printMessage(text);
                    textFieldMessage.setText("");
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = textFieldLogin.getText();
                ip = textFieldIp.getText();
                port = textFieldPort.getText();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ServerInterface server = new ServerInterface();

            ClientInterface client1 = new ClientInterface(server);
            ClientInterface client2 = new ClientInterface(server);

            client1.setVisible(true);
            client2.setVisible(true);
        });
    }
}

