package JDK.Lectures.Lecture_02.exceptions;

public class BallsOverflowException extends RuntimeException {
    public BallsOverflowException() {
        super("Невозможно создать более 15 шаров");
    }
}
