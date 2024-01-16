package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreBarrier {

	public static void main(String [] args) throws InterruptedException {
	    int numberOfThreads = 3; //or any number you'd like 
	 
	    List<Thread> threads = new ArrayList<>();
	 
	    Barrier barrier = new Barrier(numberOfThreads);
	    for (int i = 0; i < numberOfThreads; i++) {
	        threads.add(new Thread(new CoordinatedWorkRunner(barrier)));
	    }
	 
	    for(Thread thread: threads) {
	        thread.start();
	    }
	}
	
	public static class Barrier {
	    private final int numberOfWorkers;
	    private final Semaphore semaphore = 
	    		new Semaphore( 0); //** blank 1 **/);
	    private int counter = 0;//** blank 2 **/;
	    private final Lock lock = new ReentrantLock();
	 
	    public Barrier(int numberOfWorkers) {
	        this.numberOfWorkers = numberOfWorkers;
	    }
	 
	    public void waitForOthers() throws InterruptedException {
	        lock.lock();
	        System.out.println(Thread.currentThread().getName() 
	                + " after lock");

	        boolean isLastWorker = false;
	        try {
	            counter++;
		        System.out.println(Thread.currentThread().getName() 
		                + " counter++ " + counter);
	 
	            if (counter == numberOfWorkers) {
	                isLastWorker = true;
	            }
	        } finally {
		        System.out.println(Thread.currentThread().getName() 
		                + " before unlock ");
	            lock.unlock();
	        }
	 
	        if (isLastWorker) {
		        System.out.println(Thread.currentThread().getName() 
		                + " before  release");
	            semaphore.release(2);//** blank 3 **/);
	        } else {
		        System.out.println(Thread.currentThread().getName() 
		                + " before  acquire");
	            semaphore.acquire();          
	        }
	    }
	}
	 
	public static class CoordinatedWorkRunner implements Runnable {
	    private final Barrier barrier;
	 
	    public CoordinatedWorkRunner(Barrier barrier) {
	        this.barrier = barrier;
	    }
	 
	    @Override
	    public void run() {
	        try {
	            task();
	        } catch (InterruptedException e) {
	        }
	    }
	    
	    
	    private void task() throws InterruptedException {
	        // Performing Part 1
	        System.out.println(Thread.currentThread().getName() 
	                + " part 1 of the work is finished");
	 
	        barrier.waitForOthers();
	 
	        // Performing Part2
	        System.out.println(Thread.currentThread().getName() 
	                + " part 2 of the work is finished");
	    }	    
	    
	}
	
	
}
