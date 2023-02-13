package java8.threading.ShutDownHookUp;

class ShutdownHook extends Thread {
    public void run() {
        System.out.println("HookUp thread Started");
        System.out.println("Cleaning tasks have been Started");
    }
}

class HookUpTest {
    public static void main(String S[]) {
        System.out.println("maain method started");
        ShutdownHook hk = new ShutdownHook();
        Runtime r = Runtime.getRuntime();
        r.addShutdownHook(hk);
        System.out.println("main is about to finish");
    }
}