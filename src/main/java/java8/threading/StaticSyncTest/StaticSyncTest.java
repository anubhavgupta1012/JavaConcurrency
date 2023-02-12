package java8.threading.StaticSyncTest;

class StaticSyncTest {
    public static void main(String S[]) {
        new MyThread("first");
        new MyThread("second");
    }
}

class Resource {
    static int data[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    synchronized static void Update() {
        System.out.println("I m in update");
        for (int i = 0; i <= 9; i++) {
            data[i] += 10;
            System.out.println("Updated value:" + data[i]);
        }
    }

    synchronized static void Display() {
        System.out.println("I am in Display");
        for (int i = 9; i >= 0; i--) {
            System.out.println("Values :" + data[i]);
        }
    }
}

class MyThread extends Thread {

    MyThread(String name) {
        super(name);
        start();
    }

    public void run() {
        if (this.getName().equals("first"))
            Resource.Display();
        else if (this.getName().equals("second"))
            Resource.Update();

    }
}