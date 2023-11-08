package JDK.Lectures.Lecture_05.Task_01;

public class Task_01 {
    public static void main(String[] args) {
        // 1) Первый вариант
        // Мы всегда можем получить текущий поток выполнения
        System.out.println(Thread.currentThread().getName());
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("Make some work!");
            }
        };
        Thread thread = new Thread(task);
        thread.start();

    }
}
