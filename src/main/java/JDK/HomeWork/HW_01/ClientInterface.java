package JDK.HomeWork.HW_01;

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

    private final ServerInterface serverInterface = new ServerInterface();
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

    ClientInterface() {
        jpDown = new JPanel(new BorderLayout()); // Создаем панель с BorderLayout
        textFieldMessage = new JTextField();
        inputButton = new JButton("Отправить");


        // JPanel jpDown
        jpDown.add(textFieldMessage, BorderLayout.CENTER); // Размещаем поле ввода в центре панели jpDown
        jpDown.add(inputButton, BorderLayout.EAST); // Размещаем кнопку справа на панели jpDown
        add(jpDown, BorderLayout.SOUTH); // BorderLayout.SOUTH - привязываем к низу
        // Устанавливаем отступы для панели jpDown
        jpDown.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pack();


        // JPanel jpUp
        textFieldIp = new JTextField();
        textFieldPort = new JTextField();
        textFieldIp.setPreferredSize(new Dimension(174, 30));
        textFieldPort.setPreferredSize(new Dimension(174, 30));

        textFieldLogin = new JTextField();
        textFieldPassword = new JTextField();
        loginButton = new JButton("Login");

        jpUp = new JPanel(); // Создаем контейнер для размещения двух строк
        jpUp.setLayout(new BoxLayout(jpUp, BoxLayout.Y_AXIS)); // Используем вертикальное выравнивание

        // Первая строка с двумя элементами
        JPanel firstRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        firstRow.add(textFieldIp);
        firstRow.add(textFieldPort);

        // Вторая строка с тремя элементами
        JPanel secondRow = new JPanel(new GridLayout(1, 3));
        secondRow.add(textFieldLogin);
        secondRow.add(textFieldPassword);
        secondRow.add(loginButton);

        // Добавляем обе строки в jpUp
        jpUp.add(firstRow);
        jpUp.add(secondRow);

        add(jpUp, BorderLayout.NORTH);
        jpUp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pack();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Установка операции закрытия по умолчанию при закрытии окна
        setSize(WIDTH, HEIGHT); // Установка размеров окна
        setLocationRelativeTo(null); // Установка положения окна по центру
        setTitle("Client Interface"); // Установка заголовка окна
        setResizable(false); // Запрет изменения размера окна
        setVisible(true); // Установка видимости окна

        addListenerOnButton();
    }

    private void addListenerOnButton() {
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!name.isEmpty() && !ip.isEmpty() && !port.isEmpty()) {
                    String fullName = "(" + ip + " : " + port + ") " + name + ": ";
                    String text = fullName + textFieldMessage.getText();

                    // Очищаем список storyDialogs перед чтением из файла
                    storyDialogs.clear();

                    try {
                        readFromFile.read(storyDialogs);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                    storyDialogs.add(text);
                    writeToFile.write(storyDialogs);

                    serverInterface.printMessage(text);
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

}
