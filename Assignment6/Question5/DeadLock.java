/*
A deadlock occurs when two or more threads wait forever for a lock or resource held by another of the threads.
Consequently, an application may stall or fail as the deadlocked threads cannot progress.
 */

public class DeadLock {

    String R1 = "R1";
    String R2 = "R2";

    Thread T1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Starting T-0");

            // Acquired R1
            synchronized (R1) {
                try {
                    System.out.println(Thread.currentThread().getName() + " acquires R1");
                    // Sleep is added to make deadlock predictable
                    // One-second delay ensures that the other thread
                    // acquires lock on R2!
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                synchronized (R2) {
                    System.out.println("Acquired both!");
                }
            }

            // If we reach here, no deadlock!
            System.out.println("Completed T-0");
        }
    });

    Thread T2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Starting T-1");
            synchronized (R2) {
                try {
                    System.out.println(Thread.currentThread().getName() + " acquires R2");
                    Thread.sleep(1000);
                } catch (Exception ex) {
                }
                synchronized (R1) {
                    System.out.println("Acquired both!");
                }
            }
            // If we reach here, no deadlock!
            System.out.println("Completed T-1");
        }
    });

    public static void main(String[] args) {
        DeadLock deadlock = new DeadLock();
        deadlock.T1.start();
        deadlock.T2.start();
    }
}
