import java.util.concurrent.locks.ReentrantLock;

public class ResolvingDeadLock {
    private String R1 = "R1";
    private String R2 = "R2";

    private final ReentrantLock lock = new ReentrantLock();

    public void getStrings() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquires R1");
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquires R2");
                System.out.println("Acquired Both:" + R1 +","+R2);
            } finally {
                lock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ResolvingDeadLock object = new ResolvingDeadLock();

        Thread T1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting T-0");

                object.getStrings();

                System.out.println("Completed T-0");
            }
        });

        Thread T2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting T-1");

                object.getStrings();

                System.out.println("Completed T-1");

            }
        });

        T1.start();
        T2.start();
    }
}