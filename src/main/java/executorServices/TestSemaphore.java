package executorServices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 100; i++)
            executorService.submit(new Work(semaphore));
    }
}

class Work implements Runnable {

    private Semaphore semaphore;

    public Work(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started running");
        semaphore.acquireUninterruptibly(); // or semaphore.acquire();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
        System.out.println(name + " going to terminate");
    }
}