package threads;

import java.math.BigInteger;

public class ThreadInterrupt {
	
	public static void main(String[] args) {
		
		//Thread thread = new Thread(new BlockingTask());
		//thread.setName("TestBlocking1");
		//thread.start();
		//thread.interrupt();
		
		Thread thread = new Thread(
				new LongComputationTask(new BigInteger("200000"),
									    new BigInteger("1000000")));
		thread.setName("LongComputationTask");
		thread.start();
		thread.interrupt();
		
	}
	
	private static class BlockingTask implements Runnable {

		@Override
		public void run() {
			 try {
				 System.out.println("blocking thread - before sleep");
				 Thread.sleep(500000);
				 System.out.println("blocking thread -  after sleep");
			 }catch( InterruptedException e) {
				  System.out.println("Exiting blocking thrad");
			 }
			
		}
	}
	
	private static class LongComputationTask implements Runnable {
		private BigInteger base;
		private BigInteger pow;

		public LongComputationTask(BigInteger base, BigInteger pow) {
			 this.base = base;
			 this.pow = pow;
		}
		
		@Override
		public void run() {
			 System.out.println("In run");
			 BigInteger res = power(base,pow);

			 System.out.printf("%s ^ %s =  %s \n", 
						 base.toString(), pow.toString(), res.toString() );
		}

		private BigInteger power(BigInteger base, BigInteger pow) {
			BigInteger res = BigInteger.ONE;
			
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("Thread interrupted " + Thread.currentThread().getName());
				return BigInteger.ZERO;
			}
			
			for (BigInteger i = BigInteger.ZERO; i.compareTo(pow) != 0; i = i.add(BigInteger.ONE) ) {
				res = res.multiply(base);
			}
			
			return res;
			
		}
		
		
		
	}
	
	
}
