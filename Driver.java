package dsf;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;

public class Driver {
	
	public static void main(String[] args) {
		PatientGUI app = new PatientGUI();
		app.setVisible(true);
		app.setSize(800, 500);
		app.setLocation(200, 100);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer("Cosmetic");
		queue.offer("Allergy");
		queue.offer("Pain");
		
		queue.poll();
		System.out.println(queue);
	}

}
