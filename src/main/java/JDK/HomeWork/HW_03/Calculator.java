package JDK.HomeWork.HW_03;

public class Calculator {
    public static <T extends Number, U extends Number> double add(T a, U b) {
        return a.doubleValue() / b.doubleValue();
    }
}
