package java8.threading.threadInterruption;


class SumThread extends Thread {
    public void run() {
        String name = getName();
        System.out.println(name + " thread Started");
        try {
            System.out.println(" Moving in the waiting state");
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Calculating sum....");
        int sum = 0;
        int[] a = InterruptTest.getData();
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println("Sum is: " + sum);
    }
}