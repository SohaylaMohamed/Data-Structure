package eg.edu.alexu.csd.datastructure.linkedList;

/**.
 * @author Sohayla Mohamed
 *
 */
public interface ILinkedList {

	/**.
	 * Inserts a specified element at the specified sposition in the list.
	 * @param index : index to add at
	 * @param element : object to be added
	 */
	void add(int index, Object element);

	/**.
	 * Inserts the specified element at the end of the list.
	 * @param element : object to be added
	 */
	void add(Object element);

	/**.
	 * Returns the element at the specified position in this list.
	 * @param index : index to add at
	 * @return the object at the index
	 */
	Object get(int index);

	/**.
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * @param index : index to add at
	 * @param element : object to be added
	 */
	void set(int index, Object element);

	/**.
	 * Removes all of the elements from this list.
	 */
	void clear();

	/**.
	 * @return true if this list contains no elements.
	 */
	boolean isEmpty();

	/**.
	 * Removes the element at the specified position in this list.
	 * @param index : index to remove at
	 */
	void remove(int index);

	/**.
	 * @return the number of elements in this list.
	 */
	int size();

	/**.
	 * @return a view of the portion of this list between the specified
	 * @param fromIndex : the starting index
	 * @param toIndex : the ending index
	 * inclusively.
	 */
	ILinkedList sublist(int fromIndex, int toIndex);

	/**.
	 * @return true if this list contains
	 * an element with the same value as the
	 * specified element.
	 *  @param o : object to check
	 */
	boolean contains(Object o);

}
