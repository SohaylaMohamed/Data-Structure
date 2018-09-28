package eg.edu.alexu.csd.datastructure.linkedList.cs18_32;

import org.junit.Assert;
import org.junit.Test;
import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**.
 * @author Sohayla Mohamed
 *
 */
public class TestLinked {

	/**.
	 *
	 */
	@Test
	public void testGetS() {
		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;

		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		final int index = 3;

		Assert.assertEquals(n1, list.get(0));
		Assert.assertEquals(n4, list.get(index));
	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void testInvalidIndexS() {
		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.get(-1);
		final int n5 = -4;
		list.set(2, n5);
	}

	/**.
	 *
	 */
	@Test
	public void testSetS() {
		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 22;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		final int n5 = 45;
		final int n6 = 41;
		list.set(0, n4);
		list.set(1, n5);
		list.set(2, n6);
		Assert.assertEquals(n4, list.get(0));
		Assert.assertEquals(n5, list.get(1));
		Assert.assertEquals(n6, list.get(2));
	}

	/**.
	 *
	 */
	@Test
	public void testAddS() {
		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;
		final int n5 = 34;
		final int n6 = 48;
		final int n7 = 72;
		final int n8 = 90;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(0, n5);
		final int index1 = 5;
		final int index2 = 3;
		final int index3 = 7;
		Assert.assertEquals(n5, list.get(0));
		list.add(index1, n6);
		Assert.assertEquals(n6, list.get(index1));
		list.add(index2, n7);
		Assert.assertEquals(n7, list.get(index2));
		list.add(index3, n8);
		Assert.assertEquals(n8, list.get(index3));
	}

	/**.
	 *
	 */
	@Test
	public void testSubListS() {

		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		SinglyLinkedList temp = new SinglyLinkedList();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;
		final int n5 = 9;
		final int n6 = 12;
		final int index1 = 3;
		final int index2 = 5;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);
		list.add(n6);
		temp = (SinglyLinkedList) list.sublist(2, index2);
		Assert.assertEquals(n3, temp.get(0));
		Assert.assertEquals(n4, temp.get(1));
		Assert.assertEquals(n5, temp.get(2));
		Assert.assertEquals(n6, temp.get(index1));
		Assert.assertEquals(n1, temp.size());

	}

	/**.
	 *
	 */
	@Test
	public void testRemoveS() {
		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;
		final int index1 = 3;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.remove(2);
		Assert.assertEquals(n4, list.get(2));
		Assert.assertEquals(index1, list.size());
	}

	/**.
	 *
	 */
	@Test
	public void testContainsS() {
		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;
		final int n5 = 9;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		Assert.assertEquals(true, list.contains(n3));
		Assert.assertEquals(false, list.contains(n5));
	}

	/**.
	 *
	 */
	@Test
	public void testClearS() {
		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		Assert.assertEquals(n1, list.size());
		list.clear();
		Assert.assertEquals(0, list.size());
	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void testContainNullS() {
		ILinkedList list =
		(ILinkedList) TestRunner.getImplementationInstance();
		final int n4 = 5;
		final int n6 = 11;
		list.add(n4);
		list.add(2);
		list.add(n6);
		list.contains(null);
	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void testSublistEmptyS() {
		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		ILinkedList temp = new SinglyLinkedList();
		final int n1 = 4;
		final int n4 = 5;
		final int n5 = 11;
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.add(n4);
		list.add(2);
		list.add(n5);
		temp = list.sublist(1, n1);
		Assert.assertEquals(n1, temp.size());
		list.clear();
		temp = list.sublist(1, n1);

	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void testRemoveEmptyS() {
		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		final int n4 = 5;
		final int n5 = 11;
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.remove(2);
		Assert.assertEquals(n4, list.get(2));
		list.clear();
		list.remove(0);

	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void addNullS() {
		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		final int n4 = 5;
		final int n5 = 11;
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.add(null);

	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void getEmptyS() {
		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		final int n4 = 5;
		final int n5 = 11;
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.add(n4);
		list.add(2);
		list.add(n5);
		Assert.assertEquals(n5, list.get(2));
		list.clear();
		list.get(0);

	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void testContainEmptyS() {
		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		final int n4 = 5;
		final int n5 = 11;
		list.add(n4);
		list.add(2);
		list.add(n5);
		Assert.assertEquals(true, list.contains(2));
		list.clear();
		list.contains(2);
	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void sublistBoundaryS() {
		ILinkedList list =
			(ILinkedList) TestRunner.getImplementationInstance();
		ILinkedList temp = new SinglyLinkedList();
		final int n1 = 4;
		final int n2 = 7;
		final int n3 = 8;
		final int n4 = 5;
		final int n5 = 11;
		final int n6 = 12;
		final int index1 = 3;
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.add(n6);
		list.add(n2);
		list.add(n1);
		list.add(-1);
		list.add(index1);
		list.add(1);
		list.add(n3);
		temp = list.sublist(n2, 1);
	}

	/**.
	 *
	 */
	@Test
	public void testGetD() {
		ILinkedList list =
		(ILinkedList) TestRunner2.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;

		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		final int index = 3;

		Assert.assertEquals(n1, list.get(0));
		Assert.assertEquals(n4, list.get(index));
	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void testInvalidIndexD() {
		ILinkedList list =
			(ILinkedList) TestRunner2.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.get(-1);
		final int n5 = -4;
		list.set(2, n5);
	}

	/**.
	 *
	 */
	@Test
	public void testSetD() {
		ILinkedList list =
			(ILinkedList) TestRunner2.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 22;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		final int n5 = 45;
		final int n6 = 41;
		list.set(0, n4);
		list.set(1, n5);
		list.set(2, n6);
		Assert.assertEquals(n4, list.get(0));
		Assert.assertEquals(n5, list.get(1));
		Assert.assertEquals(n6, list.get(2));
	}

	/**.
	 *
	 */
	@Test
	public void testAddD() {
		ILinkedList list =
			(ILinkedList) TestRunner2.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;
		final int n5 = 34;
		final int n6 = 48;
		final int n7 = 72;
		final int n8 = 90;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(0, n5);
		final int index1 = 5;
		final int index2 = 3;
		final int index3 = 7;
		Assert.assertEquals(n5, list.get(0));
		list.add(index1, n6);
		Assert.assertEquals(n6, list.get(index1));
		list.add(index2, n7);
		Assert.assertEquals(n7, list.get(index2));
		list.add(index3, n8);
		Assert.assertEquals(n8, list.get(index3));
	}

	/**.
	 *
	 */
	@Test
	public void testSubListD() {

		ILinkedList list =
			(ILinkedList) TestRunner2.getImplementationInstance();
		DoublyLinkedList temp = new DoublyLinkedList();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;
		final int n5 = 9;
		final int n6 = 12;
		final int index1 = 3;
		final int index2 = 5;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);
		list.add(n6);
		temp = (DoublyLinkedList) list.sublist(2, index2);
		Assert.assertEquals(n3, temp.get(0));
		Assert.assertEquals(n4, temp.get(1));
		Assert.assertEquals(n5, temp.get(2));
		Assert.assertEquals(n6, temp.get(index1));
		Assert.assertEquals(n1, temp.size());

	}

	/**.
	 *
	 */
	@Test
	public void testRemoveD() {
		ILinkedList list =
			(ILinkedList) TestRunner2.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;
		final int index1 = 3;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.remove(2);
		Assert.assertEquals(n4, list.get(2));
		Assert.assertEquals(index1, list.size());
	}

	/**.
	 *
	 */
	@Test
	public void testContainsD() {
		ILinkedList list =
			(ILinkedList) TestRunner2.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;
		final int n5 = 9;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		Assert.assertEquals(true, list.contains(n3));
		Assert.assertEquals(false, list.contains(n5));
	}

	/**.
	 *
	 */
	@Test
	public void testClearD() {
		ILinkedList list =
			(ILinkedList) TestRunner2.getImplementationInstance();
		final int n1 = 4;
		final int n2 = 1;
		final int n3 = 8;
		final int n4 = 5;
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		Assert.assertEquals(n1, list.size());
		list.clear();
		Assert.assertEquals(0, list.size());
	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void testContainNullD() {
		ILinkedList list =
		(ILinkedList) TestRunner2.getImplementationInstance();
		final int n4 = 5;
		final int n6 = 11;
		list.add(n4);
		list.add(2);
		list.add(n6);
		list.contains(null);
	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void testSublistEmptyD() {
		ILinkedList list =
			(ILinkedList) TestRunner2.getImplementationInstance();
		ILinkedList temp = new DoublyLinkedList();
		final int n1 = 4;
		final int n4 = 5;
		final int n5 = 11;
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.add(n4);
		list.add(2);
		list.add(n5);
		temp = list.sublist(1, n1);
		Assert.assertEquals(n1, temp.size());
		list.clear();
		temp = list.sublist(1, n1);

	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void testRemoveEmptyD() {
		ILinkedList list =
			(ILinkedList) TestRunner2.getImplementationInstance();
		final int n4 = 5;
		final int n5 = 11;
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.remove(2);
		Assert.assertEquals(n4, list.get(2));
		list.clear();
		list.remove(0);

	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void addNullD() {
		ILinkedList list =
			(ILinkedList) TestRunner2.getImplementationInstance();
		final int n4 = 5;
		final int n5 = 11;
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.add(null);

	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void getEmptyD() {
		ILinkedList list =
			(ILinkedList) TestRunner2.getImplementationInstance();
		final int n4 = 5;
		final int n5 = 11;
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.add(n4);
		list.add(2);
		list.add(n5);
		Assert.assertEquals(n5, list.get(2));
		list.clear();
		list.get(0);

	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void testContainEmptyD() {
		ILinkedList list =
			(ILinkedList) TestRunner2.getImplementationInstance();
		final int n4 = 5;
		final int n5 = 11;
		list.add(n4);
		list.add(2);
		list.add(n5);
		Assert.assertEquals(true, list.contains(2));
		list.clear();
		list.contains(2);
	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void sublistBoundaryD() {
		ILinkedList list =
			(ILinkedList) TestRunner2.getImplementationInstance();
		ILinkedList temp = new DoublyLinkedList();
		final int n1 = 4;
		final int n2 = 7;
		final int n3 = 8;
		final int n4 = 5;
		final int n5 = 11;
		final int n6 = 12;
		final int index1 = 3;
		list.add(n4);
		list.add(2);
		list.add(n5);
		list.add(n6);
		list.add(n2);
		list.add(n1);
		list.add(-1);
		list.add(index1);
		list.add(1);
		list.add(n3);
		temp = list.sublist(n2, 1);
	}

}
