package eg.edu.alexu.csd.datastructure.queue.cs32;

import eg.edu.alexu.csd.datastructure.linkedList.cs18_32.SinglyLinkedList;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**.
 * @author Sohayla Mohamed
 *
 */
public class QueueLinked implements IQueue, ILinkedBased {
	/**.
	 *
	 */
	public SinglyLinkedList q = new SinglyLinkedList();
	/**.
	 *
	 */
	private int count;
	/**.
	 *  Inserts an item at the queue front.
	 *  @param item : an object
	 */
	public void enqueue(final Object item) {
		q.addatTail(item);
		count++;

	}

	/**.
	 *  Removes the object at the queue rear .
	 *  @return object
	 */
	public Object dequeue() {
		Object o = q.removeHead();
		count--;
		return o;
	}

	/**.
	 *  @return true if this queue is empty.
	 */
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}

	/**.
	 *  @return the number of elements in the queue
	 */
	public int size() {
		return count;
	}

}
