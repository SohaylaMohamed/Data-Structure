package eg.edu.alexu.csd.datastructure.maze.cs32;

/**.
 * @author Sohayla Mohamed
 *
 */
public class Point {
	/**.
	 *
	 */
	private int x = -1;
	/**.
	 *
	 */
	private int y = -1;

	/**.
	 * @param i x coord
	 * @param j y coord
	 */
	public void set(final int i, final int j) {
		this.x = i;
		this.y = j;
	}

	/**.
	 * @return x coord
	 */
	public int getX() {
		return this.x;
	}

	/**.
	 * @return y coord
	 */
	public int getY() {
		return this.y;
	}
}
