package java8.threading.testInterruptionJoin;

import java.util.Scanner;

public class InputThread extends Thread {
    int[] data = new int[10];

    public InputThread(String name) {
        super(name);
        //this.setDaemon(true);
        this.start();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("In Input Thread");
        System.out.println("Enter 5 values");

        for (int i = 0; i < 5; i++) {
            data[i] = sc.nextInt();
            if (i == 2) {
                JoinTest.thread.interrupt();
            }
        }
    }

    public int[] getData() {
        return data;
    }
}