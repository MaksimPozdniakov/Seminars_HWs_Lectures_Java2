package JDK.Lectures.Lecture_05.TicTac;

public class Main {
    public static void main(String[] args) {
        Thread tic = new Thread(new TicTacClass("["));
        Thread tac = new Thread(new TicTacClass("]"));
        tic.setDaemon(true); // setDaemon - это означает, что это сервисный поток. Это означает, что если MainThread
                             // закончил свою деятельность, то все сервисные потоки закончили свою деятельность. А не
                             // сервисный поток будет жить до тех пор, пока его кто-ниюудь не убьет.
        tac.setDaemon(true);
        tic.start();
        tac.start();
    }
}
