package HomeWork.HW_02;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static int lines;
    private static int columns;
    private static char[][] playingField;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random rnd = new Random();

    private static final char EMPTY_FIELD = '_';
    private static final char SIGN_OF_THE_CROSS = 'X';
    private static final char ZERO_SIGN = 'O';

    public static void main(String[] args) {
        fillPlayingField();
        printPlayingField();
        while (true) {
            playerMove();
            printPlayingField();
        }

    }

    private static void fillPlayingField() {
        System.out.print("Введите размер поля через пробел: ");
//        lines = scanner.nextInt();
//        columns = scanner.nextInt();
        lines = 5;
        columns =5;

        playingField = new char[lines][columns];

        for (int i = 0; i < playingField.length; i++) {
            for (int j = 0; j < playingField.length; j++) {
                playingField[i][j] = EMPTY_FIELD;
            }
        }
    }

    private static void printPlayingField() {
        System.out.println();

        int firstDig = 0;
        int lastDig = playingField.length - 1;

        for (int i = 0; i < columns + 2; i++) {
            if (i == firstDig || i == lastDig + 2) {
                System.out.print("* ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        int num = 1;
        for (int i = 0; i < lines; i++) {

            for (int j = 0; j < columns; j++) {

                if (j == firstDig) {
                    System.out.print(num + " " + playingField[i][j] + " ");
                } else if (j == lastDig) {
                    System.out.print(playingField[i][j] + " " + num);
                } else {
                    System.out.print(playingField[i][j] + " ");
                }
            }
            num++;
            System.out.println();
        }
        for (int i = 0; i < columns + 2; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void playerMove() {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        playingField[x][y] = SIGN_OF_THE_CROSS;
    }
}
