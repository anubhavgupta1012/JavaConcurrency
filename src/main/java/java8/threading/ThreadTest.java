package java8.threading;

class ThreadTest {
    public static void main(String S[]) {
        System.out.println("Main Thread started");
        Thread th = Thread.currentThread();
        System.out.println("Name: " + th.getName());
        System.out.println("Priority: " + th.getPriority());
        try {
            System.out.println("Main is Going to Sleep");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println("Changing the name And priority ");
        th.setName("My Main");
        th.setPriority(Thread.MAX_PRIORITY);
        System.out.println("New Name:" + th.getName());
        System.out.println("New Priority:" + th.getPriority());
    }
}
