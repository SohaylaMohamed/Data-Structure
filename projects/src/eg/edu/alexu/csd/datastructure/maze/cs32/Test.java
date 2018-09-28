package eg.edu.alexu.csd.datastructure.maze.cs32;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		MazeSolver test = new MazeSolver();
		final File file = new File("C:\\Users\\carnival\\Desktop\\maze.txt");
		test.solveBFS(file);

	}

}
