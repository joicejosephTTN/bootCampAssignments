public class CreateThread {
    public static void main(String[] args) throws InterruptedException {
        // Create thread using Thread Class
        Thread t1 = new ThreadClass();

        //Create thread using Runnable Interface
        Thread t2 = new Thread(new ThreadClass1());

        // Before join both threads execute at the same time
        // Expected output after join: Thread t1 finishes execution and then Thread t2 starts
        t1.start();
        t1.sleep(10000);
        t1.join();
        t2.start();


//        // Create thread using lambda expression
//        new Thread(()->{
//            System.out.println("Thread - using lambda");
//        }).start();
//
//        // Using anonymous inner class
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread - using anonymous inner class");
//            }
//        }).start();


    }
}
class ThreadClass extends Thread{
    @Override
    public void run() {
        System.out.println("Thread - extending Thread");
        System.out.println("Current Thread: "
                + Thread.currentThread().getName());
    }
}

class ThreadClass1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread - implements Runnable");
        System.out.println("Current Thread: "
                + Thread.currentThread().getName());
    }
}