import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

// Created 3 classes to demonstrate how threads work with un-synchronized methods,
// synchronized methods and synchronized blocks
class SynchronizedMethods {
    private int syncSum = 0;
    // Instance methods are synchronized, which means only one thread per
    // instance of the class can execute this method.
    public synchronized void synchronisedCalculate() {
        setSyncSum(getSyncSum() + 1);
        System.out.println("Current Sum (SynchronizedMethod):"  + getSyncSum());
    }

    public int getSyncSum() {
        return syncSum;
    }

    public void setSyncSum(int syncSum) {
        this.syncSum = syncSum;
    }
}
class NonSynchronizedMethods {
    private int sum = 0;

    public void calculate() {
        setSum(getSum() + 1);
        System.out.println("Current Sum:" + getSum());
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
}

class SynchronizedBlocks{
    private int blockSum = 0;

    public int getBlockSum() {
        return blockSum;
    }

    public void setBlockSum(int blockSum) {
        this.blockSum = blockSum;
    }

    public void blockCalculate() {
        System.out.println("threads entering in random order");
        synchronized (this) {
            setBlockSum(getBlockSum() + 1);
            System.out.println("Current Sum (SynchronizedBlock):" + getBlockSum());
        }
    }
}

public class SynchronizedThreads {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3); //create 3-threads pool
        NonSynchronizedMethods calcSum = new NonSynchronizedMethods(); // instantiate class
        // execute() method is void and doesn't give any possibility to get the result of a task's execution
        // or to check the task's status
        // Syntax:  executorService.execute(runnableTask);
        IntStream.range(0,100).forEach(count -> service.execute(calcSum::calculate)); // executing it 100 times
        // The shutdown() method doesn't cause immediate destruction of the ExecutorService. It will make the
        // ExecutorService stop accepting new tasks and shut down after all running threads finish their current work
        service.shutdown();


        //the expected output would be 100, but our multithreaded execution gives inconsistent results
        // because threads are independent. And we haven't used any provision to ensure they work in sync

        // 1. add the synchronized keyword to method declaration

        ExecutorService serviceSync = Executors.newFixedThreadPool(3);
        SynchronizedMethods calcSyncSum = new SynchronizedMethods();

        IntStream.range(0, 100)
                .forEach(count -> serviceSync.execute(calcSyncSum::synchronisedCalculate));
        // Expected result to be 100
        serviceSync.shutdown();


        //2. applying synchronized to a block

        ExecutorService serviceBlock = Executors.newFixedThreadPool(3);
        SynchronizedBlocks blockSum = new SynchronizedBlocks();
        IntStream.range(0, 500)
                .forEach(count -> serviceBlock.execute(blockSum::blockCalculate));
        // Expected result to be 500
        serviceBlock.shutdown();
    }
}
