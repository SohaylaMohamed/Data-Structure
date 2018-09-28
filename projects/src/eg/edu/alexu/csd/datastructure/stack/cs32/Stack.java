package eg.edu.alexu.csd.datastructure.stack.cs32;

import eg.edu.alexu.csd.datastructure.stack.IStack;
import eg.edu.alexu.csd.datastructure.linkedList.cs18_32.DoublyLinkedList;

/**.
 * @author Sohayla Mohamed
 *
 */
public class Stack implements IStack {
	/**.
	 *
	 */
	public DoublyLinkedList stack = new DoublyLinkedList();

	/**.
	 * this function add elements
	 *  at a specified index in the stack (0 is the
	 * bottom)
	 *
	 * @param index
	 *            : index in the stack
	 * @param element
	 *            the element to be inserted
	 */
	public void add(final int index, final Object element) {
		if (index < 0 || index > stack.sizeS()) {
			throw null;
		}
		stack.add(stack.sizeS() - index, element);

	}

	/**.
	 * this function removes the top element and returns it.
	 *
	 * @return the top element that has been removed
	 */
	public Object pop() {
		if (stack.sizeS() == 0) {
			throw null;
		}
		Object temp = stack.get(0);
		stack.remove(0);
		return temp;

	}

	/**.
	 * this function returns the top element of the stack.
	 *
	 * @return the top element of the stack
	 */
	public Object peek() {
		if (stack.sizeS() == 0) {
			throw null;
		}

		return stack.get(0);
	}

	/**.
	 * this function add elements at the top of the stack
	 *
	 * @param element
	 *            the element to be added.
	 */
	public void push(final Object element) {

		stack.add(0, element);

	}

	/**.
	 * this function checks if the stack is empty or not
	 *
	 * @return true if empty and false if not empty
	 */
	public boolean isEmpty() {
		if (stack.sizeS() == 0) {
			return true;
		}
		return false;
	}

	/**.
	 * this function returns the size if the array
	 *
	 * @return size , if empty returns 0
	 */
	public int size() {

		return stack.sizeS();
	}

	/**.
	 * this function prints the elements in the stack starting from the top
	 */
	public void print() {
		stack.print();
	}

}
