package JDK.Lectures.Test;

import javax.swing.*;
import java.awt.*;

class MapPanel extends JPanel {
    private int width, height, cellWidth, cellHeight;
    private int fieldSizeX, fieldSizeY;
    private int[][] field;

    public MapPanel() {
        setBackground(Color.WHITE);
    }

    public void setFieldSize(int sizeX, int sizeY) {
        this.fieldSizeX = sizeX;
        this.fieldSizeY = sizeY;
        field = new int[fieldSizeY][fieldSizeX];
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        width = getWidth();
        height = getHeight();
        cellWidth = width / fieldSizeX;
        cellHeight = height / fieldSizeY;

        g.setColor(Color.BLACK);

        for (int h = 0; h < fieldSizeX; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int w = 0; w < fieldSizeY; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, height);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] != 0) {
                    g.drawRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }
}

