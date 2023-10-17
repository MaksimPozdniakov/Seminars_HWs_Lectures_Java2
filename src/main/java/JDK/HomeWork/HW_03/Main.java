package JDK.HomeWork.HW_03;

public class Main {
    public static void main(String[] args) {
        double result = Calculator.add(5,5);
        if ((result * 10) % 10 == 0 && (result * 100) % 100 == 0) {
            System.out.println((int) result);
        } else {
            System.out.printf("%.2f", result);
        }


//        double i = 4.02;
//        double b = i * 10;
//        double t = b % 10;
//        System.out.println(t);
    }
}
