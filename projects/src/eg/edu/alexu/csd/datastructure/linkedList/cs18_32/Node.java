package eg.edu.alexu.csd.datastructure.linkedList.cs18_32;

/**.
 * @author Sohayla Mohamed
 *
 */
public class Node {

	/**.
	 *
	 */
	private Object value;
	/**.
	 *
	 */
	private Node next = null;
	/**.
	 *
	 */
	private Node prev = null;

	/**.
	 * A constructor for the node class
	 * @param n : next node
	 * @param p : prev node
	 */
	public Node(final Node n, final Node p) {

		this.next = n;
		this.prev = p;
	}

	/**.
	 * gets the value in a node
	 *
	 * @return value
	 */
	public Object getValue() {
		return value;
	}

	/**.
	 * sets a new value in the node
	 *
	 * @param v
	 *            the new value
	 */
	public void setValue(final Object v) {
		this.value = v;
	}

	/**.
	 * gets the next node
	 *
	 * @return the next node
	 */
	public Node getNext() {
		return next;
	}

	/**.
	 * sets a new next to a node
	 *
	 * @param n
	 *            the new node
	 */
	public void setNext(final Node n) {
		this.next = n;
	}

	/**.
	 * gets the prev node of a node
	 *
	 * @return the previous node
	 */
	public Node getPrev() {
		return prev;
	}

	/**.
	 * sets a new previous to a node
	 *
	 * @param p
	 *            the new node
	 */
	public void setPrev(final Node p) {
		this.prev = p;
	}

}
