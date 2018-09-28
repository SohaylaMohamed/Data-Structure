package eg.edu.alexu.csd.datastructure.iceHockey.cs32;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

/**.
 * @author Sohayla Mohamed
 *
 */
public class IhTest6 {

	/**.
	 *
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		IceHockey test = new IceHockey();
		String[] photo = {"11111", "1AAA1", "1A1A1", "1AAA1", "11111"};
		final Point[] actual = test.findPlayers(photo, 1, 3);
		final Point[] expected = {new Point(5, 5), new Point(5, 5)};
		int lenActual = actual.length;
		int lenExp = 2;
		assertEquals(expected, actual);
		assertEquals(lenExp, lenActual);
		String[] photo2 = {""};
		final Point[] actual2 = test.findPlayers(photo2, 1, 3);
		Point[] expected2 = new Point[0];
		int lenActual2 = actual2.length;
		int lenExp2 = 0;
		assertEquals(expected2, actual2);
		assertEquals(lenExp2, lenActual2);

	}

}
