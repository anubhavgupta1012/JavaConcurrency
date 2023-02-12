package java8.threading.MyRunnable;

class MyRunnable implements Runnable {
    public void run() {
        Thread th = Thread.currentThread();
        String Str = th.getName();
        System.out.println(Str + " thread Started");

        for (int i = 0; i < 11; i++) {
            System.out.println(th.getName());
        }

        System.out.println("MyRunnable is about to finish");

    }
}