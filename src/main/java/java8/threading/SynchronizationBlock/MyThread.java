package java8.threading.SynchronizationBlock;

class MyThread extends Thread {
    Resource r;

    MyThread(String name, Resource r) {
        super(name);
        this.r = r;
        start();
    }

    public void run() {
        synchronized (Resource.class) {
            String nm = getName();
            if (nm.equals("first"))
                r.Update();
            if (nm.equals("second"))
                r.Display();
        }
    }
}