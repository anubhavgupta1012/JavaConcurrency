package java8.threading.NotifyAllTest;

class NotifyAllTest {
    public static void main(String S[]) {
        Resource r = new Resource();
        new MyThread(r, "user1");
        new MyThread(r, "user2");
        new MyThread(r, "user3");
        new MyThread(r, "user4");
        new MyThread(r, "admin");
    }
}
