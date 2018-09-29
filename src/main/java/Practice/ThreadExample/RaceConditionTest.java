package Practice.ThreadExample;

public class RaceConditionTest {

	public static void main(String[] args) throws InterruptedException {
		LongWrapper longWrapper = new LongWrapper(0L);
		
		Runnable r = () ->{
			for(int i=0;i<1_00;i++) {
				longWrapper.incremnetValue();
			}
		};
		
		Thread[] threads = new Thread[1_00];
		
		for(int i =0; i< threads.length;i++) {
			threads[i] = new Thread(r);
			threads[i].start();
		}

		for(int i = 0 ; i< threads.length;i++) {
			threads[i].join();
		}
		
		System.out.println("Value : " + longWrapper.getValue());
	}

}
