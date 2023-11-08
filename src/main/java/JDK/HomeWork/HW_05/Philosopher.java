package JDK.HomeWork.HW_05;

public class Philosopher implements Runnable{
    private int id;
    private Fork leftFork;
    private Fork rightFork;
    private int count;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void eat() {
        System.out.println((id + 1) + "-й Филосов ест");
        count++;
    }

    public void think() {
        System.out.println((id + 1) + "-й Филосов думает");
        count++;
    }

    @Override
    public void run() {
        while (count < 3) {
            think();
            leftFork.takeFork();
            rightFork.takeFork();
            eat();
            rightFork.putDown();
            leftFork.putDown();
        }
    }
}
