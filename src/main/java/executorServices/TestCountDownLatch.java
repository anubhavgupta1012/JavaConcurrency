package executorServices;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Task(countDownLatch));
        executorService.submit(new Task(countDownLatch));
        executorService.submit(new Task(countDownLatch));

        System.out.println("Main is waiting for termination");
        countDownLatch.await();
        System.out.println("Main Terminated");
    }
}

class Task implements Runnable {
    private CountDownLatch latch;

    public Task(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Run(" + i + ") executed for " + Thread.currentThread().getName());
        }
        latch.countDown();
        System.out.println(Thread.currentThread().getName() + "Terminated");
    }
}