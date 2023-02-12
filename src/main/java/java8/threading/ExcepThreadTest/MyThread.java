package java8.threading.ExcepThreadTest;

class MyThread extends Thread {
    int x, y;

    MyThread(int x, int y) {
        this.x = x;
        this.y = y;
        start();
    }

    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " Started\n");
        int z = x / y;
        System.out.println("result calculation in progress for " + name + "\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println("Result= " + z + " in " + name + "\n");
    }


}


