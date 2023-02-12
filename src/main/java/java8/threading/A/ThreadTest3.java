package java8.threading.A;


class ThreadTest3 {
    public static void main(String[] s) {
        System.out.println("Main started");

        MyThread t = new MyThread();
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main");
        }
        System.out.println("Main is about to finish");
    }
}
