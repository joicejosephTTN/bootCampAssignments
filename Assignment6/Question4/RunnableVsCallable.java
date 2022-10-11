/*
The Callable interface is similar to Runnable, in that both are designed for classes
whose instances are potentially executed by another thread. A Runnable, however,
does not return a result and cannot throw a checked exception.

The callable object can return the computed result done by a thread in contrast to a runnable
interface which can only run the thread. The Callable object returns a Future object which
provides methods to monitor the progress of a task being executed by a thread. The future
object can be used to check the status of a Callable and then retrieve the result from the Callable
once the thread is done. It also provides timeout functionality.
*/


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class RunnableExample implements Runnable {


    @Override
    public void run()  {
        //Runnable does not return a result
        System.out.println("executing run() method.");
    }
}

class Summation implements Callable<Integer> {
    private int a;
    private int b;
    private boolean throwException;

    public Summation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    //Callable‘s call() method contains the “throws Exception” clause,
    // so we can easily propagate checked exceptions further
    
    @Override
    public Integer call() throws Exception {
        if(this.throwException == true) {
            throw new Exception();
        }
        //  result of call() method is returned within a Future object
        return this.a + this.b;
    }
}

public class RunnableVsCallable {
    public static void main(String[] args) throws InterruptedException {

        // Runnable requires us to override the run() method,

        // Callable is a generic interface requires us to override the call() method
        // that returns a generic value.

        Thread t1 = new Thread(new RunnableExample());
        t1.start();



        int a = 1;
        int b = 2;
        Callable<Integer> callable = new Summation(a,b);
        ExecutorService exec = Executors.newFixedThreadPool(3);
        // submit accepts callable/runnable and returns Future object
        // execute is similar but only accepts runnable and doesn't return anything

        // submit() executes the given command at some time in the future.
        // The command may execute in a new thread, in a pooled thread, or in the calling thread,
        // at the discretion of the Executor implementation
        Future<Integer> future = exec.submit(callable);


        try {

            // get() method is called to get the result
            // will print out 1 + 2 = 3
            int result = future.get();
            System.out.println(a + " + " + b + " = " + result);
        } catch (Exception e) {
            System.out.println("The error is: " + e);
        }

        // accepts no new tasks, and waits for the submitted tasks to finish.
        exec.shutdown();
    }

}

