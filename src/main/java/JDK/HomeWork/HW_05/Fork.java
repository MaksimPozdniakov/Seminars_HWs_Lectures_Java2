package JDK.HomeWork.HW_05;

import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private final ReentrantLock lock = new ReentrantLock();

    public void takeFork(){
        lock.lock();
    }

    public void putDown(){
        lock.unlock();
    }
}
