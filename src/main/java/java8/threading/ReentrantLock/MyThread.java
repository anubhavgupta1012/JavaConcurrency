package java8.threading.ReentrantLock;

class MyThread extends Thread {
    Resource r;

    MyThread(Resource r, String name) {
        super(name);
        this.r = r;
        start();
    }

    public void run() {
        if (getName().equals("first"))
            r.m1();
        if (getName().equals("second"))
            r.m1();
        if (getName().equals("third"))
            r.m2();
        if (getName().equals("fourth"))
            r.m2();
    }
}
