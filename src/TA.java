import java.util.concurrent.Semaphore;

public class TA extends Thread{


	private Semaphore sem;

	public TA(Semaphore semTA) {
		this.sem = semTA;
	}
	
	@Override
	public void run() {
		
	}
}
