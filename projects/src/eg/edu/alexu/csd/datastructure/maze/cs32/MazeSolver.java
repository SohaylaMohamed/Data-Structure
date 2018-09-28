package eg.edu.alexu.csd.datastructure.maze.cs32;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import eg.edu.alexu.csd.datastructure.linkedList.cs18_32.DoublyLinkedList;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs32.QueueLinked;
import eg.edu.alexu.csd.datastructure.stack.cs32.Stack;


/**.
 * @author Sohayla Mohamed
 *
 */
public class MazeSolver implements IMazeSolver {
	/**.
	 *
	 */
	private int rowS = -1;
	/**
	 *
	 */
	private int rowT = -1;
	/**
	 *
	 */
	private int colS = -1;
	/**
	 *
	 */
	private int colT = -1;
	/**
	 *
	 */
	private Point start;
	/**
	 *
	 */
	private Point end;
	/**
	 *
	 */
	private Stack path = new Stack();

	/**.
	 * @param maze file maze
	 * @return array of the maze
	 * @throws IOException if empty
	 */
	public char[][] readFile(final File maze) throws IOException {

		try {
			if (maze == null) {
				throw null;
			}
			BufferedReader read =
				new BufferedReader(new FileReader(maze));
			String coord = read.readLine();
			String[] split = coord.split(" ");
			int rows = Integer.valueOf(split[0]);
			int cols = Integer.valueOf(split[1]);
			if (rows == 0 || cols == 0) {
				throw null;
			}
			String readline;
			int num = 0;
			char[][] m = new char[rows][cols];
			while ((readline = read.readLine()) != null) {
				char[] ch = readline.toCharArray();
				if (ch.length != cols) {
					throw null;
				}
				for (int i = 0; i < ch.length; i++) {
					m[num][i] = ch[i];
				}
				num++;
			}
			if (num != rows) {
				throw null;
			}

			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < cols; j++) {
					System.out.print(m[i][j]);
				}
				System.out.println();
			}

			return m;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**.
	 * @param l list
	 * @param o point
	 * @return true or false
	 */
	public boolean contains(final DoublyLinkedList l, final Point o) {
		for (int i = 0; i < l.sizeS(); i++) {
			Point temp = (Point) l.get(i);
		if (temp.getX() == o.getX() && temp.getY() == o.getY()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * @param l a stack
	 * @param o point
	 * @return true or false
	 */
	public boolean cont(final Stack l, final Point o) {
		for (int i = 0; i < l.size(); i++) {
			Point temp = (Point) l.pop();
		if (temp.getX() == o.getX() && temp.getY() == o.getY()) {
				return true;
			}
		}
		return false;
	}
	/**.
	 * @param all all the visited path
	 * @return the shortest path
	 */
	public Stack findRoute(final Stack all) {
		Stack temp = new Stack();
		Point parent = ((Relation) all.peek()).getParent();
		temp.push(((Relation) all.pop()).getLoc());
		temp.push(parent);
		int flag = 0;
		final int size = all.size();
		for (int i = 0; i < size; i++) {
			if (((Point) temp.peek()).getX()
				== ((Relation) all.peek()).getLoc().getX()
			&& ((Point) temp.peek()).getY()
			== ((Relation) all.peek()).getLoc().getY()) {
				parent = ((Relation) all.pop()).getParent();
				if (parent != null) {
					temp.push(parent);
					flag = 1;
				} else {
					break;
				}

			}
			if (flag == 0) {
			all.pop();
			}
			flag = 0;
		}
		return temp;
	}
	/**
	 * . Read the maze file, and solve it using Breadth First Search
	 *
	 * @param maze
	 *            maze file
	 * @return the coordinates of the found path from point S to point E
	 *         inclusive, or null if no path found.
	 *          coordinates indexes are zero
	 *         based.
	 */
	public int[][] solveBFS(final File maze) {
		if (maze == null) {
			throw null;
			}
		char[][] m;
		try {
			m = readFile(maze);
			startAndEndTiles(m);
			start = new Point();
			Relation s = new Relation();

			start.set(rowS, colS);
			s.setRel(start, null);
			end = new Point();
			end.set(rowT, colT);
			QueueLinked temp = new QueueLinked();
			DoublyLinkedList visited = new DoublyLinkedList();
			temp.enqueue(s);
			Relation tmp;
			path.stack.clear();

			while (!temp.isEmpty()) {
				tmp = (Relation) temp.dequeue();

				visited.add(tmp.getLoc());

			if (tmp.getLoc().getX() == end.getX()
					&& tmp.getLoc().getY() == end.getY()) {
					path.push(tmp);
					break;
				}
			DoublyLinkedList n = neighbours(tmp.getLoc(), m);
				int count = 0;
				for (int i = 0; i < n.sizeS(); i++) {
					Point t = (Point) n.get(i);
					Relation te = new Relation();
			if (!contains(visited, t)
					&& m[t.getX()][t.getY()] != '#') {
						te.setRel(t, tmp.getLoc());
						temp.enqueue(te);
						count++;
					}
				}
				if (count > 0) {
					path.push(tmp);
				}
			}
			if (temp.isEmpty()
			&& ((((Relation) path.peek()).getLoc().getX()
					!= end.getX()
			|| ((Relation) path.peek()).getLoc().getY()
			!= end.getY()))) {
				return null;
			}
			path = findRoute(path);

			int[][] p = new int[path.size()][2];

			final int size = path.size();
			int k = 0;
			for (int i = size - 1; i >= 0; i--) {
				Point t = (Point) path.pop();
				if (t != null) {
				p[k][0] = t.getX();
				p[k][1] = t.getY();
				k++;
				}
			}
			for (int i = 0; i < p.length; i++) {
				for (int j = 0; j < 2; j++) {
					System.out.print(" " + p[i][j]);
				}
				System.out.println();

			}
			StringBuilder t = new StringBuilder();
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[0].length; j++) {
					t.append(m[i][j]);
				}

			}
			String n = t.toString();
			//throw new RuntimeException(n);
			return p;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**.
	 * @param m the maze
	 */
	public void startAndEndTiles(final char[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] == 'S') {
					rowS = i;
					colS = j;
				}
				if (m[i][j] == 'E') {
					rowT = i;
					colT = j;
				}
			}
		}
		if (rowS < 0 || rowT < 0 || colS < 0 || colT < 0) {
			throw null;
		}
	}

	/**.
	 * @param a first point
	 * @param b second point
	 * @return true or false
	 */
	public boolean checkparent(final Point a, final Point b) {
		if (a.getX() == b.getX()
				&& (Math.abs(a.getY() - b.getY()) == 1)) {
			return true;
		}
		if (a.getY() == b.getY()
				&& (Math.abs(a.getX() - b.getX()) == 1)) {
			return true;
		}
		return false;

	}

	/**.
	 * @param tmp point
	 * @param m the maze
	 * @return list of the neighbours
	 */
	public DoublyLinkedList neighbours(final Point tmp, final char[][] m) {
		DoublyLinkedList n = new DoublyLinkedList();
		if (tmp.getY() - 1 >= 0) {
			Point temp = new Point();
			temp.set(tmp.getX(), tmp.getY() - 1);
			n.add(temp);
		}
		if (tmp.getY() + 1 < m[0].length) {
			Point temp = new Point();
			temp.set(tmp.getX(), tmp.getY() + 1);
			n.add(temp);
		}

		if (tmp.getX() - 1 >= 0) {
			Point temp = new Point();
			temp.set(tmp.getX() - 1, tmp.getY());
			n.add(temp);
		}
		if (tmp.getX() + 1 < m.length) {
			Point temp = new Point();
			temp.set(tmp.getX() + 1, tmp.getY());
			n.add(temp);
		}
		return n;
	}

	/**
	 * . Read the maze file, and solve it using Depth First Search
	 * =
	 * @param maze
	 *            maze file
	 * @return the coordinates of the found path from point S to point E
	 *         inclusive, or null if no path found.
	 *          coordinates indexes are zero
	 *         based.
	 * @throws IOException
	 */
	public int[][] solveDFS(final File maze) {
		if (maze == null) {
			throw null;
			}
		char[][] m;
		try {
			m = readFile(maze);
			startAndEndTiles(m);
			start = new Point();
			start.set(rowS, colS);
			end = new Point();
			end.set(rowT, colT);
			Stack temp = new Stack();
			DoublyLinkedList visited = new DoublyLinkedList();
			temp.push(start);
			Point tmp;
			path.stack.clear();
			while (!temp.isEmpty()) {
				tmp = (Point) temp.pop();
				if (!path.isEmpty()) {
				while (!checkparent(tmp, (Point) path.peek())) {
						path.pop();
					}
				}
				visited.add(tmp);

			if (tmp.getX() == end.getX()
					&& tmp.getY() == end.getY()) {
					path.push(end);
					break;
				}
				DoublyLinkedList n = neighbours(tmp, m);
				int count = 0;
				for (int i = 0; i < n.sizeS(); i++) {
					Point t = (Point) n.get(i);
			if (!contains(visited, t)
					&& m[t.getX()][t.getY()] != '#') {
						temp.push(t);
						count++;
					}
				}
				if (count > 0) {
					path.push(tmp);
				}
			}
			if (temp.isEmpty()
				&& (((Point) path.peek()).getX() != end.getX()
			|| ((Point) path.peek()).getY() != end.getY())) {
				return null;
			}

			int[][] p = new int[path.size()][2];

			final int size = path.size();
			int k = size - 1;
			for (int i = 0; i < size; i++) {
				Point t = (Point) path.pop();
				p[k][0] = t.getX();
				p[k][1] = t.getY();
				k--;
			}
			for (int i = 0; i < p.length; i++) {
				for (int j = 0; j < 2; j++) {
					System.out.print(" " + p[i][j]);
				}
				System.out.println();

			}
			return p;
		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;

	}

}
