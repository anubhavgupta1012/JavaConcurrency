package java8.threading.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

class Resource {
    int x, y;
    ReentrantLock r1 = new ReentrantLock();
    ReentrantLock r2 = new ReentrantLock();

    void m1() {
        r1.lock();
        String name = Thread.currentThread().getName();
        System.out.println(name + " got the lock of r1");
        for (int i = 0; i < 10; i++) {
            int val = (int) (Math.random() * 100);
            x += val;
            System.out.println(name + " :- value of X in m1: " + x);
        }
        System.out.println(name + " :- final value of X in m1: " + x);
        r1.unlock();
    }


    void m2() {
        r2.lock();
        String name = Thread.currentThread().getName();
        System.out.println(name + "got the lock of r2");
        for (int i = 0; i < 10; i++) {
            int val = (int) (Math.random() * 100);
            y += val;
            System.out.println(name + " :- value of Y in m2: " + x);
        }
        System.out.println(name + " :- final value of Y in m2: " + x);
        r2.unlock();
    }
}



