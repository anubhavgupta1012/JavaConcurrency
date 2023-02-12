package java8.threading.Deadlock;

class MyFactory {
    static Resource r1, r2;

    static {
        r1 = new Resource();
        r2 = new Resource();
    }
}