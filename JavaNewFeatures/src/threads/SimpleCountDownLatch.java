package threads;

import java.util.ArrayList;
import java.util.List;

import threads.SemaphoreBarrier.Barrier;
import threads.SemaphoreBarrier.CoordinatedWorkRunner;

public class SimpleCountDownLatch {
	 private int count;
	 
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
	        this.count = count;
	        if (count < 0) {
	            throw new IllegalArgumentException("count cannot be negative");
	        }
	    }

	    /**
	     * Causes the current thread to wait until the latch has counted down to zero.
	     * If the current count is already zero then this method returns immediately.
	    */
	    public void await() throws InterruptedException {
	        /**
	         * Fill in your code
	         */
	    	if(count > 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
	    	}
	    	
	    }

	    /**
	     *  Decrements the count of the latch, releasing all waiting threads when the count reaches zero. 
	     *  If the current count already equals zero then nothing happens.
	     */
	    public synchronized void countDown() {
	        /**
	         * Fill in your code
	         */
	    	
	    	count--;
	    	if(count <= 0) {
	    		notifyAll();
	    	}
	    }

	    /**
	     * Returns the current count.
	    */
	    public synchronized int getCount() {
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
		        barrier.wait();
		 
		        // Performing Part2
		        System.out.println(Thread.currentThread().getName() 
		                + " part 2 of the work is finished");
		    }	    
		    
		}
}
