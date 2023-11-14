package threads;

public class ThreadInterrupt {
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(new BlockingTask());
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
}
