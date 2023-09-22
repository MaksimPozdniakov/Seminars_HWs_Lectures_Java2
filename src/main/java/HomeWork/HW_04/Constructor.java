package HomeWork.HW_04;

import java.util.Random;

public class Constructor {

    private int rows;
    private int columns;
    private final String[][] stringArray;
    private static final Random random = new Random();

    public Constructor(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.stringArray = new String[rows][columns];
    }

    //region Getters and Setters

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    //endregion

    public boolean check() throws MyArraySizeException{
        if (rows != 4) {
            throw new MyArraySizeException("Строк должно быть 4");
        }

        if (columns != 4) {
            throw new MyArraySizeException("Колонок должно быть 4");
        }
        return true;
    }


    public String[][] getStringArray() throws MyArraySizeException {

        if (!check()) {
            return null;
        }

        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray.length; j++) {
                stringArray[i][j] = String.valueOf(random.nextInt(5) + 1);
            }
        }
        return stringArray;
    }

    public int sum(String[][] array) throws MyArraySizeException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += Integer.parseInt(array[i][j]);
            }
        }
        return sum;
    }

    public void print(String[][] array) throws MyArraySizeException {

        if (!check()) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
