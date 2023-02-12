package java8.threading.Deadlock;

class MyThread extends Thread {
    MyThread(String name) {
        super(name);
        start();
    }

    public void run() {
        if (getName().equals("user1"))
            MyFactory.r1.sumcalc();

        if (getName().equals("user2")){
            MyFactory.r2.sumcalc();
            }
    }
}