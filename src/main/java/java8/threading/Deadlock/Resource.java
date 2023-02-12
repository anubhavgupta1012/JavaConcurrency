package java8.threading.Deadlock;

class Resource {
    int sum;

    synchronized void sumcalc() {
        String name = Thread.currentThread().getName();
        for (int i = 1; i <= 10; i++) {
            int x = (int) (Math.random() * 100);
            sum += x;
        }
        System.out.println("Sum of " + name + "=" + sum);

        if (name.equals("user1")) {
            System.out.println("try to get the sum of user 2 , may be in deadlock");
            int otherSum = MyFactory.r2.getSum();
            System.out.println("Total sum in user1: " + (sum + otherSum));
        }

        if (name.equals("user2")) {
            System.out.println("try to get the sum of user 1 , may be in deadlock");
            int otherSum = MyFactory.r1.getSum();
            System.out.println("Total sum in user2 : " + (sum + otherSum));
        }
    }

    synchronized int getSum() {
        return sum;
    }
}