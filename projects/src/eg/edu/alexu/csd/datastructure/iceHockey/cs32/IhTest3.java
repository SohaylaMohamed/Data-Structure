package eg.edu.alexu.csd.datastructure.iceHockey.cs32;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

/**.
 * @author Sohayla Mohamed
 *
 */
public class IhTest3 {

	/**.
	 *
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		IceHockey test = new IceHockey();
		String[] photo = {"8D88888J8L8E888",
				"88NKMG8N8E8JI88",
				"888NS8EU88HN8EO",
				"LUQ888A8TH8OIH8",
				"888QJ88R8SG88TY",
				"88ZQV88B88OUZ8O",
				"FQ88WF8Q8GG88B8",
				"8S888HGSB8FT8S8",
				"8MX88D88888T8K8",
				"8S8A88MGVDG8XK8",
				"M88S8B8I8M88J8N",
				"8W88X88ZT8KA8I8",
				"88SQGB8I8J88W88",
				"U88H8NI8CZB88B8",
				"8PK8H8T8888TQR8"};
		final Point[] actual = test.findPlayers(photo, 8, 9);
		final Point[] expected = {new Point(1, 17),
				new Point(3, 3),
				new Point(3, 10),
				new Point(3, 25),
				new Point(5, 21),
				new Point(8, 17),
				new Point(9, 2),
				new Point(10, 9),
				new Point(12, 23),
				new Point(17, 16),
				new Point(18, 3),
				new Point(18, 11),
				new Point(18, 28),
				new Point(22, 20),
				new Point(23, 26),
				new Point(24, 15),
				new Point(27, 2),
				new Point(28, 26),
				new Point(29, 16)};
		int lenActual = actual.length;
		final int lenExp = 19;
		assertEquals(expected, actual);
		assertEquals(lenExp, lenActual);
	}

}
