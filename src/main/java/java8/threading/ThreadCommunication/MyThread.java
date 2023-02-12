package java8.threading.ThreadCommunication;

class MyThread extends Thread {
    Resource r;

    MyThread(String str, Resource r) {
        super(str);
        this.r = r;
        start();
    }

    public void run() {
        String nm = getName();
        if (nm.equals("first")) {
            r.update(nm);
        }
        if (nm.equals("second")) {
            r.display(nm);
        }
    }
}