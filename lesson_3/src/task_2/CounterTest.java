package task_2;

public class CounterTest {

    public static int counter;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100_000; i++) {
            new CounterIncrementor();
        }

        Thread.sleep(1000);
        System.out.println(counter);
    }
}