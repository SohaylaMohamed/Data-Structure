package eg.edu.alexu.csd.datastructure.maze.cs32;

/**.
 * @author Sohayla Mohamed
 *
 */
public class Relation {

	/**.
	 *
	 */
	private Point location;
	/**.
	 *
	 */
	private Point parent;

	/**.
	 * @param l location
	 * @param p parent
	 */
	public void setRel(final Point l, final Point p) {
		this.location = l;
		this.parent = p;
	}
	/**.
	 * @return location
	 */
	public Point getLoc() {
		return this.location;
	}
	/**
	 * @return parent location
	 */
	public Point getParent() {
		return this.parent;
	}

}
