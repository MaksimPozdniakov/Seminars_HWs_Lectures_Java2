package JDK.Lectures.Lecture_05.TicTac;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello (MyRunnable); " + Thread.currentThread().getName());
    }
}
