package JDK.Lectures.Lecture_05.Task_02;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new MyThread().start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(new MyRunnable()).start();
        }

        // Тоже самое, только через лямбду
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("Hello (Лямбда); " + Thread.currentThread().getName());
            }).start();
        }
    }
}
