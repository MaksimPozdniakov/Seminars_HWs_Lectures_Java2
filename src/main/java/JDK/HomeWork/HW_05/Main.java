package JDK.HomeWork.HW_05;

public class Main {
    public static void main(String[] args) {
        int quantity = 5;
        Philosopher[] philosophers = new Philosopher[quantity];
        Fork[] forks = new Fork[quantity];

        for (int i = 0; i < quantity; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < quantity; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % quantity]);
            new Thread(philosophers[i]).start();
        }

    }
}
