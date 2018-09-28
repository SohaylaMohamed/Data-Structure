package eg.edu.alexu.csd.datastructure.queue;

/**.
 * @author Sohayla Mohamed
 *
 */
public interface IQueue {
	/**.
	 *  Inserts an item at the queue front.
	 *  @param item : an object
	 */
	void enqueue(Object item);

	/**.
	 *  Removes the object at the queue rear .
	 *  @return object
	 */
	Object dequeue();

	/**.
	 *  @return true if this queue is empty.
	 */
	boolean isEmpty();

	/**.
	 *  @return the number of elements in the queue
	 */
	int size();

}
