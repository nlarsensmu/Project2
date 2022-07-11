
import java.util.concurrent.*;

public class Student extends Thread {

	private String name;
	private Semaphore sem;

	public Student(Semaphore sem, String name) {
		this.name = name;
		this.sem =sem;
	}
	
	public String getStudentName() {
		return this.name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Driver.TAHelp(name);
		
		System.out.println(name + " has left the TA's office");
		
		sem.release();
		
		
	}

}
