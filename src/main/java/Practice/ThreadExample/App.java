package Practice.ThreadExample;

import java.util.Scanner;


/**
 * Hello world!
 *
 */

class Processor extends Thread{
	private boolean running = true;
	
	public void run() {
		
		while(running) {
			System.out.println("Hello");
			
			try {
				Thread.sleep(100);
			}catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	public void shutDown() {
		running = false;
	}
	
}
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Processor processor = new Processor();
        processor.start();
        
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        processor.shutDown();
        scanner.close();
    }
}
