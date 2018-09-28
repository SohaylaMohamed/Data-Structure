package eg.edu.alexu.csd.datastructure.queue.cs32;

import java.util.Scanner;

public class QueueMain {

	public static void main(String[] args) {
		
		QueueLinked test = new QueueLinked();
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3);
		test.enqueue(4);
		test.enqueue(5);
		
		System.out.println("Size="+test.size());
		test.dequeue();
		test.dequeue();
		test.dequeue();
		test.dequeue();
		test.dequeue();
	Object o=	test.dequeue();
	System.out.println(o);
	System.out.println("Size="+test.size());

	

	}

}
