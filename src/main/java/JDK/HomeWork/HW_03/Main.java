package JDK.HomeWork.HW_03;

public class Main {
    public static void main(String[] args) {
        // Задание №1
        System.out.println("Задание №1");
        double[] results = {
                Calculator.sum(5, 7),
                Calculator.multiply(5, 5),
                Calculator.divide(5, 7),
                Calculator.subtract(5, 5)};

        for (double result : results) {
            if ((result * 10) % 10 == 0 && (result * 100) % 100 == 0) {
                System.out.println((int) result);
            } else {
                System.out.printf("%.2f%n", result);
            }
        }

        // Задание №2
        System.out.println();
        System.out.println("Задание №2");
        String[] stringArray1 = new String[5];
        String[] stringArray2 = new String[5];
        Integer[] intArray1 = new Integer[5];
        Integer[] intArray2 = new Integer[5];
        boolean result = Calculator.compareArrays(intArray1, stringArray1);
        System.out.println(result);

        // Задание №3
        System.out.println();
        System.out.println("Задание №3");
        Pair<String, Integer> pair = new Pair<>("Строка", 10);
        System.out.println("First = " + pair.getFirst());
        System.out.println("Second = " + pair.getSecond());
        System.out.println("Pair = " + pair);


    }


}
