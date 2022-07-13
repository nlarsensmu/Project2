/*
 * A student is a thread that will run through 10 cycles of programming on their own
 * And asking the TA for help
 */
import java.util.Random;
import java.util.concurrent.*;

public class Student extends Thread {

	private String name;
	private Semaphore sem;
	private Semaphore semChair;

	public Student(Semaphore sem, Semaphore semChair, String name) {
		this.name = name;
		this.sem = sem;
		this.semChair = semChair;
	}
	
	public String getStudentName() {
		return this.name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 3; i++) {
			try {
				// First try and take one of the 3 chairs
				print("waiting on a chair");
				semChair.acquire();
				
				// Now that we have one of the chairs wait our turn of the TA.
				print("Has a chair waiting on TA");
				sem.acquire();
				
				print("has TA's attention releasing chair");
				// Now it is out turn for the TA we give up our chair.
				semChair.release();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Driver.TAHelp(name);
			
			print("left the TA's office, relasing TA");
			
			sem.release();


			// So some work on your own without the TA
			Random randy = new Random();
			int sleepTime;
			try {
				int index = Math.abs(randy.nextInt()) % Driver.sleepOptions.length;
				sleepTime = Driver.sleepOptions[index];
				
				print("working on their own for " + sleepTime + " units");
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			print("finished their task that took " + sleepTime + " units");
		}
		
	}
	public void print(String s) {
		
		System.out.println(Thread.currentThread().getName() + " " + this.name + ":\t\t"
				+ s);
		
	}
}
