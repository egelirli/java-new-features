package threads.blockingio;


/*
 * Copyright (c) 2023. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Michael Pogrebinsky - Top Developer Academy
 * Thread Per Task Threading Model
 * https://www.udemy.com/java-multithreading-concurrency-
performance-optimization
 */

public class IoBoundApplicationV2 {
    private static final int NUMBER_OF_TASKS = 10;

    public static void main(String[] args) {
        System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS);

        long start = System.currentTimeMillis();
        performTasks();
        System.out.printf("Tasks took %dms to complete\n", System.currentTimeMillis() - start);
    }

    private static void performTasks() {
        //try (ExecutorService executorService = Executors.newFixedThreadPool(1000)) {
    	ExecutorService executorService = null;
    	try {
    		executorService = Executors.newFixedThreadPool(10);
    		
            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        for (int j = 0; j < 10; j++) {
                            blockingIoOperation();
                        }
                    }
                });
            }	
		} finally { 
			System.out.println("In Finally");
			try {
				executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

       // }
    }

    // Simulates a long blocking IO
    private static void blockingIoOperation() {
        System.out.println("Executing a blocking task from thread: " + Thread.currentThread());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
