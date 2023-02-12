package java8.threading.NotifyAllTest;

class MyThread extends Thread {
    Resource r;

    MyThread(Resource r, String nm) {
        super(nm);
        this.r = r;
        start();
    }

    public void run() {
        String name = getName();
        if (name.equals("admin")) {
            r.keyGen();
        } else {
            r.logIn();
        }
    }
}