package java8.threading.threadInterruption;

import java.io.*;

class InterruptTest {
    static int[] a = new int[10];

    public static void main(String S[]) throws IOException {
        System.out.println("main started");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SumThread th = new SumThread();
        th.start();
        System.out.println("Enter 10 Values...");

        for (int i = 0; i < 10; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        th.interrupt();
        System.out.println("main is going to finish");
    }


    static int[] getData() {
        return (a);
    }
}