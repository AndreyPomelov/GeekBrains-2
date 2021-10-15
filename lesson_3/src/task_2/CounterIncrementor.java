package task_2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterIncrementor implements Runnable {

    private static final Lock lock = new ReentrantLock();

    public CounterIncrementor() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
                CounterTest.counter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}