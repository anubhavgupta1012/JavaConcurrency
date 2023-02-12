package java8.threading.MyRunnable;

class ThreadTest2 {
    public static void main(String[] s) {
        System.out.println("Main started");
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main");
        }
        System.out.println("Main is about to finish");
    }
}
