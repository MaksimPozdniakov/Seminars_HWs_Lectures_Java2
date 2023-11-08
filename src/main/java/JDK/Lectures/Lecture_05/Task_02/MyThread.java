package JDK.Lectures.Lecture_05.Task_02;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello (MyThread); " + Thread.currentThread().getName());
    }
}
