package java8.threading.NotifyAllTest;

class Resource {
    boolean b;
    int key;

    void logIn() {
        String nm = Thread.currentThread().getName();
        System.out.println(nm + " Thread is started login");
        synchronized (this) {
            try {
                if (!b) {
                    System.out.println(nm + " is going into waiting section");
                    wait();
                }
                System.out.println(nm + " gets logged in with  " + key + " key");
            } catch (Exception e) {
            }
        }
    }

    synchronized void keyGen() {
        System.out.println("admin logged in");
        key = (int) (Math.random() * 100);
        System.out.println(key + " key Generated");
        b = true;
        notifyAll();
    }
}
				
