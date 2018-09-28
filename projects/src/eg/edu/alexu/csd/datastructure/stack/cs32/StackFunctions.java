package eg.edu.alexu.csd.datastructure.stack.cs32;

import java.util.Scanner;

/**.
 * @author Sohayla Mohamed
 *
 */
public class StackFunctions {
	/**.
	 *
	 */
	private Scanner s = new Scanner(System.in);
	/**.
	 *
	 */
	private Stack test = new Stack();
	/**.
	 * main finction
	 */
	public void main() {
		System.out.println("Please choose one of"
				+ " the following Operations:\n"
				+ "1.Push a new element.\n"
				+ "2.Pop an element from the stack.\n"
				+ "3.Return the "
				+ "top element of "
				+ "the stack without removing it.\n"
				+ "4.Get the size of the stack.\n"
				+ "5.Check if the Stack is empty or not.\n"
				+ "-----------------------------------"
				+ "---------------------------"
				+ "----------------------"
				);
		String op = s.next();
		switch (op) {
			case "1" : pushEl(); break;
			case "2" : pop(); break;
			case "3" : peek(); break;
			case "4" : size(); break;
			case "5" : empty(); break;
			default: System.out.println("Invalid");
					main(); return;
		}
		System.out.println();
		main();
		return;
	}
	/**.
	 * pushing elements
	 */
	public void pushEl() {
		System.out.println("Please Enter the value of the element");
		Object o = s.next();
		test.push(o);
		System.out.println("The element is pushed successfully.");
		main();
		return;
	}

	/**.
	 * removing last element and returning it
	 */
	public void pop() {
		if (test.isEmpty()) {
			System.out.println("The stack is Empty"
				+ " please start pushing some elements first!");
			main();
			return;
		}

		Object o = test.pop();
		System.out.println("The Object at the top was");
		System.out.print(o);
		System.out.println();

		main();
		return;

	}

	/**.
	 * seeing the last element
	 */
	public void peek() {
		if (test.isEmpty()) {
			System.out.println("The stack is Empty"
				+ " please start pushing some elements first!");
			main();
			return;
		}
		Object o = test.peek();
		System.out.println("The Object at the top is");
		System.out.print(o);
		System.out.println();
		main();
		return;
	}

	/**.
	 * size of stack
	 */
	public void size() {
		int size = test.size();
		System.out.printf("The Stack's size = %d", size);
		System.out.println();
		main();
		return;
	}
	/**.
	 * check if empty
	 */
	public void empty() {
		boolean e = test.isEmpty();
		if (e) {
			System.out.println("The Stack is empty.");
		} else {
			System.out.println("The Stack is not empty.");
		}
		main();
		return;
	}
}

