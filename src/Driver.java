
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Driver {

	static int[] sleepOptions = {50, 100, 500, 750, 1000, 1500, 2000}; 

	public static void main(String[] args) {

		// agrs[0] has an input file

		String fileName = args[0];
		ArrayList<Student> students = new ArrayList<Student>();
    	BufferedReader reader;

		Semaphore sem = new Semaphore(1);
		Semaphore semChair = new Semaphore(3);
		
		TA ta = new TA(sem);
		
		
    	try {
    		reader = new BufferedReader(new FileReader(fileName));

    		String line = reader.readLine();
    		while (line != null) {
    			Student t = new Student(sem, semChair, line);
    			students.add(t);
    			line = reader.readLine();
    		}
    		
    		reader.close();
		} catch(IOException e) {
			e.printStackTrace();
			return;
		}
    	
    	// Shuffle up the order the students start
    	Collections.shuffle(students);
    	
    	for (int i = 0; i < students.size(); i++)
    		students.get(i).start();
	}
	
	
	public static void TAHelp(String name) {
		print("Helping student "
				+ name);
		// So some work
		Random randy = new Random();

		int sleepTime;
		try {
			int index = Math.abs(randy.nextInt()) % sleepOptions.length;
			sleepTime = sleepOptions[index];
			
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		print(name + " took " + sleepTime + " units");
	}
	
	public static void print(String s) {
		System.out.println(Thread.currentThread().getName() + " TA:\t\t" + s);
	}
}
