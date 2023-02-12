package java8.threading.ThreadCommunication;

class Resource {
    int data[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    boolean b;

    synchronized void update(String N) {
        System.out.println("I am in Update");
        try {
            for (int i = 0; i <= 9; i++) {
                if (b) {
                    this.wait();
                }
                data[i] += 10;
                System.out.println("In " + N + " Updated Value is: " + data[i]);
                this.notify();
                b = true;
            }
        } catch (InterruptedException e) {
        }
    }

    synchronized void display(String N) {
        System.out.println("I am in Display");
        try {
            for (int i = 0; i <= 9; i++) {
                if (!b) {
                    this.wait();
                }
                data[i] += 10;
                System.out.println("In " + N + " Value is: " + data[i]);
                this.notify();
                b = false;
            }
        } catch (InterruptedException e) {
        }
    }
}
