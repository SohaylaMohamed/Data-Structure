package eg.edu.alexu.csd.datastructure.iceHockey.cs32;



import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

/**.
 * @author Sohayla Mohamed
 *
 */
public class IhTest1 {

    /**.
	 *
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		IceHockey test = new IceHockey();
		String[] photo = {"33JUBU33", "3U3O4433", "O33P44NB",
				"PO3NSDP3", "VNDSD333", "OINFD33X"};
		final int exp = 3;
		final int value = 16;
		Point[] actual = test.findPlayers(photo, exp, value);
		final int x1 = 4;
		final int x2 = 13;
		final int x3 = 14;
		final int y1 = 5;
		final int y2 = 9;
		final int y3 = 2;
		Point[] expected = {new Point(x1, y1),
				new Point(x2, y2), new Point(x3, y3)};
		int lenActual = actual.length;
		final int lenExp = 3;
		assertEquals(expected, actual);
		assertEquals(lenExp, lenActual);

	}

}
