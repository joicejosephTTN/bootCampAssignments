public class Question3 {
    public static void main(String args[]) {
        // Thread Example without lambda
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("Thread1 Created...");
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();

        // Thread Example with lambda
        // uses functional interface Runnable
        Runnable r2 = () -> {
            System.out.println("Thread2 Created...");
        };
        Thread t2 = new Thread(r2);
        t2.start();
    }
}
