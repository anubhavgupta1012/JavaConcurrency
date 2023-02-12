package java8.threading.A;

class MyThread extends Thread {
    public void run() {
        String name = getName();
        System.out.println(name + " Thread Started");
        for (int i = 0; i < 11; i++) {
            System.out.println(name + " :" + i);
        }
        System.out.println(name + "Thread is about to finish");
    }
}