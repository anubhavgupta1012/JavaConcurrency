package java8.threading.ReentrantLock;

class ReentrantTest {
    public static void main(String S[]) {
        Resource r = new Resource();
        new MyThread(r, "first");
        new MyThread(r, "second");
        new MyThread(r, "third");
        new MyThread(r, "fourth");
    }
}