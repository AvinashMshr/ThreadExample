package Practice.ThreadExample;

public class ProducerConsumerProblem {

	private static Object lock = new Object();
	private static int buffer[];
	private static int count ;
	static class Producer{
		void produce() {
			synchronized(lock) {
				if(isFull(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				buffer[count++] = 1;
				lock.notify();
			}

		}
		
		boolean isFull(int[] buffer) {
			return count == buffer.length;
		}
	}
	
	static class Consumer{
		void consume() {
			synchronized(lock) {
				if(isEmpty(buffer)){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				buffer[count--] = 0;
				lock.notify();
			}

		}
		
		boolean isEmpty(int[] buffer) {
			return count == 0;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		buffer = new int[50];
		count = 0;
		Object obj = new Object();
		obj.equals("Test");
		String str = new String("Avinash");
		str.equals("Deepu");
		str.intern();
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		Runnable produceTask = () -> {
			for(int i =0;i<50;i++) {
				producer.produce();
			}
			System.out.println("Done producing");
		};
		
		Runnable consumeTask = () -> {
			for(int i =0;i<45;i++) {
				consumer.consume();;
			}
			System.out.println("Done Consuming");
		};

		Thread consumerThread = new Thread(consumeTask);
		Thread produceThread = new Thread(produceTask);
		
		consumerThread.start();
		produceThread.start();
		
		consumerThread.join();
		produceThread.join();
		
		System.out.println("Data in  buffer " + count);
	}

}
