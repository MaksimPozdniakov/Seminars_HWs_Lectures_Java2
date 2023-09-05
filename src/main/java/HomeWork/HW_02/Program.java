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
                System.out.println("Ваш ход!");
                playerMove();
                printPlayingField();
                if (checkWin()) {
                    System.out.println("Конец игры! Вы победили!");
                    break;
                }

                System.out.println();
                System.out.println("Ход компьютера!");
                botMove();
                printPlayingField();
                if (checkWin()) {
                    System.out.println("Конец игры! Победил компьютер!");
                    break;
                }
                System.out.println();
            } else {
                System.out.println("Ход компьютера!");
                botMove();
                printPlayingField();
                if (checkWin()) {
                    System.out.println("Конец игры! Победил компьютер!");
                    break;
                }

                System.out.println();
                System.out.println("Ваш ход!");
                playerMove();
                printPlayingField();
                if (checkWin()) {
                    System.out.println("Конец игры! Вы победили!");
                    break;
                }
                System.out.println();
            }

        }

    }

    private static void fillPlayingField() {
        System.out.print("Введите размер поля через пробел: ");
        lines = scanner.nextInt();
        columns = scanner.nextInt();

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

        int x = -1; // Исходное значение координат
        int y = -1; // Исходное значение координат

        String string = checkStateGameForBot();

        if (!string.equals("0")) {
            String[] s = string.split(",");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
        }

        if (x == -1) {
            // Если координаты не заданы или некорректны, или ячейка не пуста,
            // то генерируем случайные координаты
            do {
                x = rnd.nextInt(lines);
                y = rnd.nextInt(columns);
            } while (!isEmptyField(x, y) || !isCorrectCoordinate(x, y));
        }

        // Выполняем ход бота
        if (!resultLottery) {
            playingField[x][y] = SIGN_OF_THE_CROSS;
        } else {
            playingField[x][y] = ZERO_SIGN;
        }
    }

    private static String checkStateGameForBot() {

        int size = playingField.length;

        // Делаем проверку по горизонтали
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j < size - 2 && playingField[i][j] != EMPTY_FIELD &&
                        playingField[i][j] == playingField[i][j + 1]) {
                    if (isEmptyField(i, j + 2)) {
                        return i + "," + (j + 2); // Если доступен ход j + 2, то возвращаем его
                    }
                } else if (j >= 2 && playingField[i][j] != EMPTY_FIELD &&
                        playingField[i][j] == playingField[i][j - 1]) {
                    if (isEmptyField(i, j - 2)) {
                        return i + "," + (j - 2); // Если ход j + 2 сделать невозможно, идем назад
                    }
                }
            }
        }

        // Делаем проверку по вертикали
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i < size - 2 && playingField[i][j] != EMPTY_FIELD &&
                        playingField[i][j] == playingField[i + 1][j]) {
                    if (isEmptyField(i + 2, j)) {
                        return i + 2 + "," + j;
                    }
                } else if (i >= 2 && playingField[i][j] != EMPTY_FIELD &&
                        playingField[i][j] == playingField[i - 1][j]) {
                    if (isEmptyField(i - 2, j)) {
                        return (i - 2) + "," + j;
                    }
                }
            }
        }

        // Делаем проверку по диагонали
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j < size - 2 && i < size - 2 && playingField[i][j] != EMPTY_FIELD &&
                        playingField[i][j] == playingField[i+ 1][j + 1]) {
                    if (isEmptyField(i + 2, j + 2)) {
                        return (i + 2) + "," + (j + 2);
                    }
                } else if (j >= 2 && i >= 2 && playingField[i][j] != EMPTY_FIELD &&
                        playingField[i][j] == playingField[i - 1][j - 1]) {
                    if (isEmptyField(i - 2, j - 2)) {
                        return (i - 2) + "," + (j - 2);
                    }
                }
            }
        }

        return "0";
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

    private static boolean checkWin() {

        // проверка по горизонтали
        int size = playingField.length;
        for (int i = 0; i < size - 2; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (playingField[i][j] != EMPTY_FIELD &&
                                playingField[i][j] == playingField[i][j + 1] &&
                                playingField[i][j] == playingField[i][j + 2]){
                    return true;
                }
            }
        }

        //  проверка по вертикали
        for (int i = 0; i < size - 2; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (playingField[i][j] != EMPTY_FIELD &&
                                playingField[i][j] == playingField[i + 1][j] &&
                                playingField[i][j] == playingField[i + 2][j]){
                    return true;
                }
            }
        }

        // проверка по диагонали
        for (int i = 0; i < size - 2; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (playingField[i][j] != EMPTY_FIELD &&
                                playingField[i][j] == playingField[i+1][j+1] &&
                                playingField[i][j] == playingField[i+2][j+2]){
                    return true;
                }
            }
        }
        return false;
    }

}
