package java8.threading.printingTest;

public class PrintTest {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new MyThread("A", resource);
        new MyThread("B", resource);
        new MyThread("C", resource);
    }
}

class MyThread extends Thread {
    Resource resource;

    public MyThread(String name, Resource resource) {
        super(name);
        this.resource = resource;
        start();
    }

    public void run() {
        String name = Thread.currentThread().getName();

        if (name.equalsIgnoreCase("A")) {
            try {
                resource.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (name.equalsIgnoreCase("B")) {
            try {
                resource.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                resource.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Resource {
    int a = 1;

    synchronized void printA() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("A");
            if (a == 1) {
                a = 2;
                this.notify();
            }
            wait();
        }
    }

    synchronized void printB() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("B");
            if (a == 2) {
                a = 3;
                this.notify();
            }
            wait();
        }

    }

    synchronized void printC() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("C");
            if (a == 3) {
                a = 1;
                this.notify();
            }
            wait();
        }
    }
}

