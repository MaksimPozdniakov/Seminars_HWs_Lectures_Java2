package JDK.HomeWork.HW_02.client;

import JDK.HomeWork.HW_02.server.Server;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientView extends JFrame implements ClientInterface {

    private static final int WIDTH = 555;
    private static final int HEIGHT = 555;

    private JTextArea jTextAreaField;
    private JPanel jPanelHeader, jPanelFooter;
    private JButton inputButton, loginButton;
    private JTextField textFieldMessage, textFieldIp, textFieldPort, textFieldLogin, textFieldPassword;

    private final Client client;
    private boolean statusServer;
    private ArrayList<String> dialogs;

    public ClientView(Server server) {
        client = new Client(server, this);

        createPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Client Interface");
        setVisible(true);

        addListenerOnButton();
    }

    private Component createHeaderPanel() {
        jPanelHeader = new JPanel(new GridLayout(2,3));
        textFieldIp = new JTextField();
        textFieldPort = new JTextField();
        textFieldLogin = new JTextField();
        textFieldPassword = new JTextField();
        loginButton = new JButton("Подключиться");

        jPanelHeader.add(textFieldIp);
        jPanelHeader.add(textFieldPort);
        jPanelHeader.add(new JPanel());
        jPanelHeader.add(textFieldLogin);
        jPanelHeader.add(textFieldPassword);
        jPanelHeader.add(loginButton);

        return jPanelHeader;
    }

    private Component createFooter() {
        jPanelFooter = new JPanel(new BorderLayout());
        textFieldMessage = new JTextField();
        inputButton = new JButton("Отправить");

        jPanelFooter.add(textFieldMessage);
        jPanelFooter.add(inputButton, BorderLayout.EAST);

        return jPanelFooter;
    }

    private Component createTextAreaField() {
        jTextAreaField = new JTextArea();
        jTextAreaField.setEditable(false);

        return new JScrollPane(jTextAreaField);
    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createTextAreaField());
        add(createFooter(), BorderLayout.SOUTH);
    }

    private void addListenerOnButton() {

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.answerStatusServer();

                String ip = textFieldIp.getText();
                String port = textFieldPort.getText();
                String login = textFieldLogin.getText();
                String password = textFieldPassword.getText();

                if (statusServer) {
                    if (!ip.isEmpty() && !port.isEmpty() && !login.isEmpty() && !password.isEmpty()) {
                        pushUserData(login,ip,port,password);
                        customInformation();
                    }
                } else {
                    jTextAreaField.setText("Server disconected!");
                }

            }
        });

        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = textFieldMessage.getText();
                if (!message.isEmpty()) {
                    sendMessage(message);
                    textFieldMessage.setText("");
                }
            }
        });
    }

    private void customInformation() {
        final String[] messages = {
                "Server connected!",
                "Loading Dialogs ...",
        };
        int delay = 1000;

        Timer timer = new Timer(delay, null);
        int[] index = {0};

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index[0] < messages.length) {
                    jTextAreaField.setText(messages[index[0]]);
                    index[0]++;
                } else {
                    ((Timer)e.getSource()).stop();
                    printStory();
                }
            }
        };

        timer.addActionListener(actionListener);
        timer.setInitialDelay(0);
        timer.start();
    }

    private void pushUserData(String login,String ip,String port,String password) {
        client.fillUserData(login,ip,port,password);
    }


    @Override
    public void statusServer(boolean status) {
        statusServer = status;
    }


    // метод который отправляет сообщение с экрана в клиент
    private void sendMessage(String message) {
        client.sendMessage(message);
    }


    // метод перебирает сообщения и выводит на экран
    @Override
    public void print(ArrayList<String> allDialogs) {

        dialogs = new ArrayList<>();

        dialogs.addAll(allDialogs);
        StringBuilder allMessages = new StringBuilder();
        for (String s : dialogs) {
            allMessages.append(s).append("\n");
        }

        jTextAreaField.setText(allMessages.toString());

    }


    private void printStory() {
        ArrayList<String> story = new ArrayList<>(client.getDialogs());
        StringBuilder allMessages = new StringBuilder();
        for (String s : story) {
            allMessages.append(s).append("\n");
        }

        jTextAreaField.setText(allMessages.toString());
    }
}