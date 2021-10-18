package task_1;

public class PingPongWriter implements Runnable {

    private final String message;
    private static volatile String condition = "PONG";
    private static final Object monitor = new Object();

    public PingPongWriter(String message) {
        this.message = message;
        new Thread(this).start();
    }

    @Override
    public void run() {
        synchronized (monitor) {
            for (int i = 0; i < 10; i++) {
                while (condition.equals(message)){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(message);
                condition = message;
                monitor.notifyAll();
            }
        }
    }
}
