package java8.threading.ThreadObjectAsNormalObj;


class SumThread extends Thread {
    int sum;

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
        int[] a = InterruptTest.getData();
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        System.out.println("Sum calculated");
    }

    int getSum() {
        return (sum);
    }
}