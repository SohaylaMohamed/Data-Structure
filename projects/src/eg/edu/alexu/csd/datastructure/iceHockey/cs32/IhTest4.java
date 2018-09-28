package eg.edu.alexu.csd.datastructure.iceHockey.cs32;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

/**.
 * @author Sohayla Mohamed
 *
 */
public class IhTest4 {

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
	}

}
