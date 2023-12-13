package JDK.ClassWork.Seminar_05.Task_01;

public class Friend {
    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void bow(Friend friend){
        System.out.println(name + ": " + friend.getName() + " поклонился мне");
        friend.bowBack(this);
    }

    private synchronized void bowBack(Friend friend){
        System.out.println(name + ": кланяемся в ответ " + friend.getName());
    }
}
