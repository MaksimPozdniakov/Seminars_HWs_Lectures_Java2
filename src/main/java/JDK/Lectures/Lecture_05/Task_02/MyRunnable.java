package JDK.Lectures.Lecture_05.Task_02;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello (MyRunnable); " + Thread.currentThread().getName());
    }
}
