package executorServices;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCyclicBarrier {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(new Job(barrier));
        executorService.submit(new Job(barrier));
        executorService.submit(new Job(barrier));
        System.out.println("Main Terminated");
    }
}

class Job implements Runnable {
    private CyclicBarrier barrier;

    public Job(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Run(" + i + ") executed for " + name);
        }
        System.out.println(name + "Terminated");
    }
}