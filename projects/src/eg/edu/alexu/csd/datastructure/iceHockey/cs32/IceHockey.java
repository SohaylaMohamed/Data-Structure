package eg.edu.alexu.csd.datastructure.iceHockey.cs32;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

/**.
 * @author Sohayla Mohamed
 *
 */
public class IceHockey implements IPlayersFinder {
	/**
	 * .
	 *
	 */
	public static final int MAX_SIZE = 50;
	/**
	 * .
	 *
	 */
	private static char digit = '0';
	/**
	 * .
	 *
	 */
	private Point[] points = new Point[MAX_SIZE];
	/**
	 * .
	 *
	 */
	private int k;
	/**
	 * .
	 *
	 */
	private int count;
	/**
	 * .
	 *
	 */
	private float sqrs;
	/**
	 * .
	 *
	 */
	private int startX;
	/**
	 * .
	 *
	 */
	private int startY;
	/**
	 * .
	 *
	 */
	private int endX;
	/**
	 * .
	 *
	 */
	private int endY;

	/**
	 * @param x1
	 *            the y coordinate of the first cell
	 * @param x2
	 *            the y coordinate of the last cell
	 * @param y1
	 *            the x coordinate of the first cell
	 * @param y2
	 *            the x coordinate of the last cell
	 * @return the center location coordeinates
	 */
	public Point avg(final int x1,
			final int x2, final int y1, final int y2) {
		Point loc = new Point(0, 0);
		final int pl = 1;
		loc.y = (x2 + x1 + pl);
		loc.x = (y2 + y1 + pl);

		return loc;
	}

	/**
	 * @param x
	 *            the row number
	 * @param y
	 *            the column number
	 * @param visited
	 *            the boolean array that shows the teams locations
	 * @param rows
	 *            the number of rows
	 * @param cols
	 *            the number of columns
	 */
	public void dfs(final int x, final int y,
			final boolean[][] visited,
			final int rows, final int cols) {
		int i;
		int j;
		if (x <= startX) {
			startX = x;
		}
		if (x >= endX) {
			endX = x;
		}
		if (y <= startY) {
			startY = y;
		}
		if (y >= endY) {
			endY = y;
		}
		visited[x][y] = false;
		for (i = x - 1; i <= x + 1 && i < rows;) {
			if (i < 0) {
				i++;
			} else {
				if (i == x) {
				for (j = y - 1; j <= y + 1 && j < cols;) {
						if (j < 0) {
							j++;
						} else {
							if (visited[i][j]) {
								count++;

						dfs(i, j, visited, rows, cols);

							}
							j++;
						}
					}
				} else {
					if (visited[i][y]) {
						count++;

						dfs(i, y, visited, rows, cols);

					}

				}
				i++;
			}

		}

	}

	/**
	 * . Search for players locations at the given photo
	 *
	 * @param photo
	 *            Two dimension array of photo
	 *            contents Will contain between 1
	 *            and 50 elements, inclusive
	 * @param team
	 *            Identifier of the team
	 * @param threshold
	 *            Minimum area for an element Will be between 1 and 10000,
	 *            inclusive
	 * @return Array of players locations of the given team
	 */

	public Point[] findPlayers(final String[] photo,
			final int team, final int threshold) {

		char[][] array = new char[photo.length][];
		final int size = 4;
		sqrs = (float) Math.ceil((float) threshold / size);
		for (int i = 0; i < photo.length; i++) {
			array[i] = photo[i].toCharArray();
		}
		boolean[][] visited =
				new boolean[photo.length][photo[0].length()];
		int rows = photo.length;
		int cols = photo[0].length();

		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[0].length(); j++) {
				if (array[i][j] == (char) (team + digit)) {
					visited[i][j] = true;
				} else {
					visited[i][j] = false;

				}

			}
		}

		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[0].length(); j++) {
				if (visited[i][j]) {
					count++;
					startX = i;
					startY = j;
					dfs(i, j, visited, rows, cols);
					if (count >= sqrs) {

						points[k] = avg(startX,
								endX,
								startY, endY);
						k++;

					}

				}

				count = 0;
				startX = 0;
				endX = 0;
				startY = 0;
				endY = 0;

			}
		}
		Point[] locations = new Point[k];

		if (points == null) {

			return null;

		} else {
			for (int i = 0; i < k; i++) {
				locations[i] = points[i];
			}
			final int t = 9999999;
			int min = t;

			Point temp;
			for (int i = 0; i < k - 1; i++) {
				min = i;
				for (int j = i + 1; j < k; j++) {
					if (locations[j].x < locations[min].x) {
						min = j;
					} else {
				if (locations[j].x == locations[min].x) {
				if (locations[j].y <= locations[min].y) {
								min = j;
							} else {
								min = min;
							}
						} else {
							min = min;
						}
					}
				}
				temp = locations[i];
				locations[i] = locations[min];
				locations[min] = temp;

			}
			k = 0;
			return locations;
		}

	}

}
