package eg.edu.alexu.csd.datastructure.queue.cs32;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**.
 * @author Sohayla Mohamed
 *
 */
public class QueueArray implements IQueue, IArrayBased {
	/**.
	 *
	 */
	private int count;
	/**.
	 *
	 */
	private int r;
	/**.
	 *
	 */
	private int f;
	/**.
	 *
	 */
	private Object[] q;
	/**
	 * @param n size of array
	 */
	public QueueArray(final int n) {
		this.q = new Object[n];
		this.r = -1;
		this.f = -1;
		this.count = 0;
	}
	/**.
	 *  Inserts an item at the queue front.
	 *  @param item : an object
	 */
	public void enqueue(final Object item) {
		if ((r + 1) % q.length == f) {
			throw null;
		} else if (isEmpty()) {
			r = 0;
			f = 0;
		} else {
			r = (r + 1) % q.length;
		}
		q[r] = item;
		count++;
	}
	/**.
	 *  Removes the object at the queue rear .
	 *  @return object
	 */
	public Object dequeue() {
		Object temp;
		if (isEmpty()) {
			throw null;
		} else if (f == r) {
			temp = q[f];
			f = -1;
			r = -1;
			count--;
		} else {
			temp = q[f];
			f = (f + 1) % q.length;
			count--;
		}
		return temp;
	}
	/**.
	 *  @return true if this queue is empty.
	 */
	public boolean isEmpty() {
		if (f == -1 && r == -1) {
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

	/**.
	 * print the queue
	 */
	public void print() {
		for (int i = f; i <= r; i++) {
			System.out.println(q[i]);
		}
	}

}
