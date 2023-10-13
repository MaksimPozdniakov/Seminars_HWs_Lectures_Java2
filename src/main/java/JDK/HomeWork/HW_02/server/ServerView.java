package JDK.HomeWork.HW_02.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerView extends JFrame {

    private static final int WIDTH = 555;
    private static final int HEIGHT = 555;

    private JPanel jpServer;
    private JTextArea log;
    private JButton jbStart, jbStop;

    public boolean status;
    private ServerInterface listener;

    public ServerView(ServerInterface listener) {

        this.listener = listener;

        jpServer = new JPanel(new GridLayout(1,2));
        jbStart = new JButton("Start");
        jbStop = new JButton("Stop");
        jpServer.add(jbStart);
        jpServer.add(jbStop);
        add(jpServer, BorderLayout.SOUTH);

        log = new JTextArea();
        add(log);

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Server Interface");
        setVisible(true);

        addListenerOnButton();
    }

    private void addListenerOnButton() {
        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status = true;
                log.setText(showMessageOfStatus());
                listener.statusServer(status);
            }
        });

        jbStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status = false;
                log.setText(showMessageOfStatus());
                listener.statusServer(status);
            }
        });
    }

    private String showMessageOfStatus() {
        if (status) {
            return "The server is running";
        } else {
            return "The server is stopped";
        }
    }

}
