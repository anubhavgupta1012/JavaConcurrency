package java8.threading.SynchronizationBlock;

class SynchTest {
    public static void main(String S[]) {
        Resource r = new Resource();
        new MyThread("first", r);
        new MyThread("second", r);
    }
}
