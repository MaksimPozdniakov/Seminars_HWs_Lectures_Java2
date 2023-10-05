package JDK.Lectures.Lecture_01;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;
    String currentWinValue = "Установленная длина: ";
    String currentFieldValue = "Установленный размер поля: ";
    int minSize = 3;

    JLabel choiceHA, fieldSize, currentSize, winSize, currentWinSize;
    JSlider sliderFieldSize, sliderWinSize;

    JRadioButton human, ai;
    ButtonGroup buttonGroup;

    JButton btnStart;
    JPanel mainPanel;

    SettingWindow(GameWindow gameWindow){
        btnStart = new JButton("Start new game");
        mainPanel = new JPanel(new GridLayout(9,1));
        choiceHA = new JLabel("Выберите режим игры");
        mainPanel.add(choiceHA);
        fieldSize = new JLabel("Выберите размеры поля");
        currentSize = new JLabel(currentFieldValue + minSize);
        sliderFieldSize = new JSlider(minSize,10,minSize);
        currentWinSize = new JLabel(currentWinValue + minSize);
        winSize = new JLabel("Выберите длину для победы");
        sliderWinSize = new JSlider(minSize,10,minSize);

        buttonGroup = new ButtonGroup();
        human = new JRadioButton("Человек против человека");
        ai = new JRadioButton("Человек против компьютера");
        buttonGroup.add(ai);
        buttonGroup.add(human);

        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                gameWindow.startNewGame(0, 3, 3, 3);
            }
        });

        sliderWinSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentWinSize.setText(currentWinValue + sliderWinSize.getValue());
            }
        });

        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentSize.setText(currentFieldValue + sliderFieldSize.getValue());
            }
        });

        add(mainPanel);
        human.setSelected(true);
        mainPanel.add(human);
        mainPanel.add(ai);
        mainPanel.add(fieldSize);
        mainPanel.add(currentSize);
        mainPanel.add(sliderFieldSize);
        mainPanel.add(winSize);
        mainPanel.add(currentWinSize);
        mainPanel.add(sliderWinSize);
        add(btnStart, BorderLayout.SOUTH);
    }
}
