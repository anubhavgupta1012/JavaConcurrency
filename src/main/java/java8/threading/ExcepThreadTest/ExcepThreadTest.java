package java8.threading.ExcepThreadTest;

class ExcepThreadTest {
    public static void main(String S[]) {
        new MyThread(4, 2);
        new MyThread(4, 0);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("main is About to terminate");
        }
    }
}


