package JDK.HomeWork.HW_03;

public class Calculator {

    public static <T extends Number> double sum(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number> double multiply(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number> double divide(T a, T b) {
        return a.doubleValue() / b.doubleValue();
    }

    public static <T extends Number> double subtract(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static <T> boolean compareArrays(T[] first, T[] second) {
        int length1 = 0;
        int length2 = 0;
        for (int i = 0; i < first.length; i++) {
            length1 += 1;
        }
        for (int i = 0; i < second.length; i++) {
            length2 += 1;
        }
        return length1 == length2;
    }

}
