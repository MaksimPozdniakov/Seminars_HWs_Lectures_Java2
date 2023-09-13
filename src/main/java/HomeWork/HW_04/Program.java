package HomeWork.HW_04;


import java.util.Random;

public class Program {

    private static final Constructor constructor = new Constructor(5,4);

    public static void main(String[] args) throws MyArraySizeException,MyArrayDataException {
        System.out.println("Задание №1 и №2");

        String[][] stringArray = constructor.getStringArray();
        constructor.print(stringArray);
        System.out.println("Сумма элементов нашего массива = " + constructor.sum(stringArray));

        System.out.println();
        System.out.println("Задание №3");

        String[][] stringArray2 = changeItemArray();

        for (int i = 0; i < stringArray2.length; i++) {
            for (int j = 0; j < stringArray2.length; j++) {
                try {
                    int value = Integer.parseInt(stringArray2[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("\nНевозможно преобразовать элемент массива в число. " +
                            "Индекс элемента: " + "[" + i + "]" + "[" + j + "]" +
                            " = '" + stringArray2[i][j] + "'");
                }
            }
        }

    }

    public static String[][] changeItemArray() throws MyArraySizeException {
        String[][] stringArray = constructor.getStringArray();
        Random random = new Random();
        int num = random.nextInt(stringArray.length);
        stringArray[num][num] = "баг";

        return stringArray;
    }
}
