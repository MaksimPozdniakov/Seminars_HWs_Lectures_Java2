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
    private static boolean resultLottery;

    public static void main(String[] args) {
        fillPlayingField();
        printPlayingField();
        System.out.println();

        resultLottery = lottery();
        System.out.println();

        while (true) {
            if (resultLottery) {
                playerMove();
                printPlayingField();
                botMove();
                printPlayingField();
            } else {
                botMove();
                printPlayingField();
                playerMove();
                printPlayingField();
            }

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
            if (i == firstDig || i == lastDig + 2) {
                System.out.print("* ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void playerMove() {
        System.out.print("Укажите координату по вертикали и по горизонтали через пробел: ");
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;

        if (resultLottery) {
            playingField[x][y] = SIGN_OF_THE_CROSS;
        } else {
            playingField[x][y] = ZERO_SIGN;
        }
    }

    private static void botMove() {
        int x, y;
        do {
            x = rnd.nextInt(lines);
            y = rnd.nextInt(columns);
        } while (!isEmptyField(x,y) || !isCorrectCoordinate(x,y));
        if (!resultLottery) {
            playingField[x][y] = SIGN_OF_THE_CROSS;
        } else {
            playingField[x][y] = ZERO_SIGN;
        }
    }

    private static boolean isCorrectCoordinate(int x, int y) {
        return x >= 0 && x < lines && y >= 0 && y < columns;
    }

    private static boolean isEmptyField(int x, int y) {
        return playingField[x][y] == EMPTY_FIELD;
    }

    private static boolean lottery() {

        String text = """
                    Сейчас будет разыгранно первеснтво хода.
                    1 - это орел, 2 - это решка
                    """;
        System.out.print(text);
        System.out.println();

        System.out.print("Киньте монетку: ");
        int choice = scanner.nextInt();
        int result = rnd.nextInt(3);

        if (result == 1) {
            System.out.println("Выпал орел!");
            if (choice == result) {
                System.out.println("За вами первый ход! Вы играете X");
                return true;
            } else {
                System.out.println("Первым ходит компьютер! Вы играете 0");
                return false;
            }
        } else {
            System.out.println("Выпала решка!");
            if (choice == result) {
                System.out.println("За вами первый ход! Вы играете X");
                return true;
            } else {
                System.out.println("Первым ходит компьютер! Вы играете 0");
                return false;
            }
        }
    }

}
