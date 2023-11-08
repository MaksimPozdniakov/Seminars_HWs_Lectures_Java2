package JDK.Lectures.Lecture_05.TicTac;

public class TicTacClass implements Runnable{
    private final String bracket;

    public TicTacClass(String bracket) {
        this.bracket = bracket;
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(bracket);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
