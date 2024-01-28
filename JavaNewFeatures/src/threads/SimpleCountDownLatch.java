package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import threads.SemaphoreBarrier.Barrier;
import threads.SemaphoreBarrier.CoordinatedWorkRunner;

public class SimpleCountDownLatch {
	 private int count;
	 //private Object countLock = new Object();
	 private final Lock countLock = new ReentrantLock();
	 
	  public static void main(String [] args) throws InterruptedException {
		    int numberOfThreads = 3; //or any number you'd like 
		 
		    List<Thread> threads = new ArrayList<>();
		 
		    SimpleCountDownLatch latch = new SimpleCountDownLatch(numberOfThreads);
		    for (int i = 0; i < numberOfThreads; i++) {
		        threads.add(new Thread(new CoordinatedWorkRunner(latch)));
		    }
		 
		    for(Thread thread: threads) {
		        thread.start();
		    }
		}
		
	    public SimpleCountDownLatch(int count) {
//	    	System.out.printf("In SimpleCountDownLatch - %s -  count : %d \n", 
//	    								Thread.currentThread().getName(),count);
	        this.count = count;
	        if (count < 0) {
	            throw new IllegalArgumentException("count cannot be negative");
	        }
	    }

	    /**
	     * Causes the current thread to wait until the latch has counted down to zero.
	     * If the current count is already zero then this method returns immediately.
	    */
	    public synchronized void await() throws InterruptedException {
	        /**
	         * Fill in your code
	         */
	    	
	    	//synchronized (countLock) {
		    	while(count > 0) {
		    		System.out.printf("In await - before wait- %s -  count %d \n", 
		    				Thread.currentThread().getName(), count);
		    		wait();
		    	}
		    	System.out.printf("In await - after wait- %s -  count %d \n", 
		    							Thread.currentThread().getName(), count);
			//}

	    	
	    }

	    /**
	     *  Decrements the count of the latch, releasing all waiting threads when the count reaches zero. 
	     *  If the current count already equals zero then nothing happens.
	     */
	    public synchronized void countDown() {
	        /**
	         * Fill in your code
	         */
	    	
	    	//synchronized (countLock) {
		    	count--;
		    	System.out.printf("In countDown - %s -  count : %d \n", 
		    							Thread.currentThread().getName(), count);
	    	//}
	    	if(count <= 0) {
	    		notifyAll();
	    	}

	    }

	    /**
	     * Returns the current count.
	    */
	    public int getCount() {
	        /**
	         * Fill in your code
	         */
	    	return count;
	    }
	    
	    
		public static class CoordinatedWorkRunner implements Runnable {
		    private final SimpleCountDownLatch barrier;
		 
		    public CoordinatedWorkRunner(SimpleCountDownLatch barrier) {
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
		        barrier.countDown();
		        barrier.await();
		 
		        // Performing Part2
		        System.out.println(Thread.currentThread().getName() 
		                + " part 2 of the work is finished");
		    }	    
		    
		}
}
