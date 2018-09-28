package eg.edu.alexu.csd.datastructure.iceHockey.cs32;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

/**.
 * @author Sohayla Mohamed
 *
 */
public class IhTest5 {

	/**.
	 *
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		IceHockey test = new IceHockey();
		String[] photo = {""};
		final Point[] actual = test.findPlayers(photo, 1, 3);
		Point[] expected = new Point[0];
		int lenActual = actual.length;
		int lenExp = 0;
		assertEquals(expected, actual);
		assertEquals(lenExp, lenActual);
	}

}
