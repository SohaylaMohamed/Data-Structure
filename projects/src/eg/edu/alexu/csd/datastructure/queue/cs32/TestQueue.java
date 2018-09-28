package eg.edu.alexu.csd.datastructure.queue.cs32;

import eg.edu.alexu.csd.datastructure.queue.IQueue;

import org.junit.Assert;
import org.junit.Test;

/**.
 * @author Sohayla Mohamed
 *
 */
public class TestQueue {
	/**.
	 *
	 */
	@Test(expected = NullPointerException.class)
	public void full() {
		IQueue list = (IQueue) TestArray.getImplementationInstance();
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
	}

	/**.
	 *
	 */
	@Test(expected = NullPointerException.class)
	public void dequeueEmpty() {
		IQueue list = (IQueue) TestArray.getImplementationInstance();
		list.dequeue();
	}

	/**.
	 *
	 */
	@Test
	public void enqueue() {
		IQueue list = (IQueue) TestArray.getImplementationInstance();
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		final int n1 = 3;
		Assert.assertEquals(n1, list.size());
	}

	/**.
	 *
	 */
	@Test
	public void checkEmpty() {
		IQueue list = (IQueue) TestArray.getImplementationInstance();
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		list.dequeue();
		list.dequeue();
		list.dequeue();
		Assert.assertEquals(0, list.size());
		Assert.assertEquals(true, list.isEmpty());
	}

	/**
	 *
	 */
	@Test
	public void dequeu() {
		IQueue list = (IQueue) TestArray.getImplementationInstance();
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		list.dequeue();
		Assert.assertEquals(2, list.size());
		Assert.assertEquals(false, list.isEmpty());
	}

	/**.
	 *
	 */
	@Test
	public void objectAtFront() {
		IQueue list = (IQueue) TestArray.getImplementationInstance();
		list.enqueue('a');
		list.enqueue('b');
		list.enqueue('c');
		Object o = list.dequeue();
		Assert.assertEquals('a', o);
		Assert.assertEquals(2, list.size());
		Assert.assertEquals(false, list.isEmpty());
	}

	/**.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void dequeueEmptyL() {
		IQueue list = (IQueue) TestLinked.getImplementationInstance();
		list.dequeue();
	}

	/**.
	 *
	 */
	@Test
	public void enqueueL() {
		IQueue list = (IQueue) TestLinked.getImplementationInstance();
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		final int n1 = 3;
		Assert.assertEquals(n1, list.size());
	}

	/**.
	 *
	 */
	@Test
	public void checkEmptyL() {
		IQueue list = (IQueue) TestLinked.getImplementationInstance();
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		list.dequeue();
		list.dequeue();
		list.dequeue();
		Assert.assertEquals(0, list.size());
		Assert.assertEquals(true, list.isEmpty());
	}

	/**.
	 *
	 */
	@Test
	public void dequeuL() {
		IQueue list = (IQueue) TestLinked.getImplementationInstance();
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		list.dequeue();
		Assert.assertEquals(2, list.size());
		Assert.assertEquals(false, list.isEmpty());
	}

	/**.
	 *
	 */
	@Test
	public void objectAtFrontL() {
		IQueue list = (IQueue) TestLinked.getImplementationInstance();
		list.enqueue('a');
		list.enqueue('b');
		list.enqueue('c');
		Object o = list.dequeue();
		Assert.assertEquals('a', o);
		Assert.assertEquals(2, list.size());
		Assert.assertEquals(false, list.isEmpty());
	}

}
