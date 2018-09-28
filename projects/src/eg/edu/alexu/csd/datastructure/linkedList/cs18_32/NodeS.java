package eg.edu.alexu.csd.datastructure.linkedList.cs18_32;

/**.
 * @author Sohayla Mohamed
 *
 */
public class NodeS {

	/**.
	 *
	 */
	private Object value;
	/**.
	 *
	 */
	private NodeS next;

	/**.
	 * gets the value of a node
	 *
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**.
	 * sets a new value to a node
	 *
	 * @param v
	 *            the new value
	 */
	public void setValue(final Object v) {
		this.value = v;
	}

	/**.
	 * gets the next node of a node
	 *
	 * @return the next node
	 */
	public NodeS getNext() {
		return next;
	}

	/**.
	 * sets a new next node to a node
	 *
	 * @param node2
	 *            the new node
	 */
	public void setNext(final NodeS node2) {
		this.next = node2;
	}

}
