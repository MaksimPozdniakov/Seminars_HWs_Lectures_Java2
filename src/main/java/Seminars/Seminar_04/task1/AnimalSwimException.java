package Seminars.Seminar_04.task1;

public class AnimalSwimException extends AnimalActionException{
    public AnimalSwimException(String message, String name, int distance) {
        super(message, name, distance);
    }
}
