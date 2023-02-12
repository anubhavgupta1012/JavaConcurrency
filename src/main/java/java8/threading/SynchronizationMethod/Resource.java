package java8.threading.SynchronizationMethod;

class Resource {
    int data[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    synchronized void Update() {
        System.out.println("I m in update");
        for (int i = 0; i <= 9; i++) {
            data[i] += 10;
            System.out.println("Updated value:" + data[i]);
        }
    }

    synchronized void Display() {
        System.out.println("I am in Display");
        for (int i = 9; i >= 0; i--) {
            System.out.println("Values :" + data[i]);
        }
    }
}

