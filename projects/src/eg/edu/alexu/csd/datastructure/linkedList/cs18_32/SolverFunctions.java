package eg.edu.alexu.csd.datastructure.linkedList.cs18_32;

import java.util.Scanner;

/**.
 * @author Sohayla Mohamed
 *
 */
public class SolverFunctions {

	/**.
	 *
	 */
	private PolynomialSolver test = new PolynomialSolver();

	/**.
	 * the main function that calles the other functions
	 */
	public void app() {
		System.out.println();
		System.out.println("=========================="
			+ "========================================== ");
		String message = "Please Choose The Action\n "
				+ "-------------------------\n"
				+ "1- Set a polynomial variable\n"
				+ "2- Print the value of "
				+ "a polynomial variable\n"
				+ "3- Add two polynomials\n"
				+ "4- Subtract two polynomials\n"
				+ "5- Multiply two polynomials\n"
				+ "6- Evaluate a polynomial at some point\n"
				+ "7- Clear a polynomial variable\n"
				+ "---------------------------------"
				+ "------------------------------------";
		System.out.println(message);
		Scanner s = new Scanner(System.in);
		int op = s.nextInt();
		final int c1 = 1;
		final int c2 = 2;
		final int c3 = 3;
		final int c4 = 4;
		final int c5 = 5;
		final int c6 = 6;
		final int c7 = 7;
		switch (op) {
		case c1:
		setPolynomial();
			break;
		 case c2:
		printVar();
			break;
		case c3:
		add();
			break;
		case c4:
		subtract();
			break;
		case c5:
		multiply();
			break;
		case c6:
		evaluate();
			break;
		case c7:

		clear();
			break;
		default: System.out.println("Invalid");
			app();
			break;
		}
		app();
		return;
	}

	/**.
	 * sets a new polynomial
	 */
	public void setPolynomial() {

		Scanner s = new Scanner(System.in);
		System.out.println("Insert the variable name: A, B or C");
		String c;
		c = s.next();
		char ch = c.charAt(0);

		if (ch != 'A' && ch != 'a' && ch != 'b'
				&& ch != 'B' && ch != 'c' && ch != 'C') {
			System.out.println("Invalid input !");
			setPolynomial();
			return;
		}
		System.out.println("Insert the number of"
				+ " terms in the polynomial:");
		int noTerms = s.nextInt();
		int[][] input = new int[noTerms][2];
		for (int i = 0; i < noTerms; i++) {
			System.out.printf("Enter coeff of term %d", i);
			input[i][0] = s.nextInt();

			System.out.printf("Enter the exponent of term %d", i);
			input[i][1] = s.nextInt();

			while (input[i][1] < 0) {
				System.out.printf("Enter the "
						+ "exponent of term %d", i);
				input[i][1] = s.nextInt();
			}
			if (i > 0) {
				if (input[i - 1][1] < input[i][1]) {
					System.out.println("Terms of the"
					+ " polynomial must be ordered.");
					System.out.printf("Enter the "
						+ "exponent of term %d", i);
					input[i][1] = s.nextInt();
				}
			}
		}
		test.setPolynomial(ch, input);
		app();
		return;

	}

	/**.
	 * print a polynomial
	 */
	public void printVar() {

		Scanner s = new Scanner(System.in);
		System.out.println("Insert the variable name: A, B, C or R");
		String c;
		c = s.next();
		char ch = c.charAt(0);
		if (ch != 'A' && ch != 'a' && ch != 'b'
				&& ch != 'B' && ch != 'c'
				&& ch != 'C' && ch != 'r' && ch != 'R') {
			System.out.println("Invalid input !");
			setPolynomial();
			return;
		}
		if (test.checkSet(ch)) {
			System.out.println("Variable not set");
			printVar();
			return;
		}
		System.out.printf("Value in %c :", ch);
		String val = test.print(ch);
		System.out.print(val);

		app();
		return;

	}

	/**.
	 * add two polynomials
	 */
	public void add() {
		Scanner s = new Scanner(System.in);
		System.out.println("Insert first"
				+ " operand variable name: A, B or C");
		String c;
		c = s.next();
		char ch = c.charAt(0);
		if (ch != 'A' && ch != 'a' && ch != 'b'
				&& ch != 'B' && ch != 'c' && ch != 'C') {
			System.out.println("Invalid Variable !");
			add();
			return;
		}
		if (test.checkSet(ch)) {
			System.out.println("Variable not set ");
			add();
			return;
		}
		System.out.println("Insert second operand"
				+ " variable name: A, B or C");
		c = s.next();
		char ch2 = c.charAt(0);
		if (ch2 != 'A' && ch2 != 'a' && ch2 != 'b'
				&& ch2 != 'B' && ch2 != 'c' && ch2 != 'C') {
			System.out.println("Invalid Variable !");
			add();
			return;
		}
		if (test.checkSet(ch2)) {
			System.out.println("Variable not set ");
			add();
			return;
		}
		test.add(ch, ch2);
		app();
		return;
	}

	/**.
	 * subtract two polynomials
	 */
	public void subtract() {
		Scanner s = new Scanner(System.in);
		System.out.println("Insert first operand "
				+ "variable name: A, B or C");
		String c;
		c = s.next();
		char ch = c.charAt(0);
		if (ch != 'A' && ch != 'a' && ch != 'b'
				&& ch != 'B' && ch != 'c' && ch != 'C') {
			System.out.println("Invalid Variable !");
			subtract();
			return;
		}
		if (test.checkSet(ch)) {
			System.out.println("Variable not set ");
			subtract();
			return;
		}
		System.out.println("Insert second "
				+ "operand variable name: A, B or C");
		c = s.next();
		char ch2 = c.charAt(0);
		if (ch2 != 'A' && ch2 != 'a' && ch2 != 'b'
				&& ch2 != 'B' && ch2 != 'c' && ch2 != 'C') {
			System.out.println("Invalid Variable !");
			subtract();
			return;
		}
		if (test.checkSet(ch2)) {
			System.out.println("Variable not set ");
			subtract();
			return;
		}
		test.subtract(ch, ch2);
		app();
		return;
	}

	/**.
	 * multiply two polynomials
	 */
	public void multiply() {
		Scanner s = new Scanner(System.in);
		System.out.println("Insert first "
				+ "operand variable name: A, B or C");
		String c;
		c = s.next();
		char ch = c.charAt(0);
		if (ch != 'A' && ch != 'a' && ch != 'b'
				&& ch != 'B' && ch != 'c' && ch != 'C') {
			System.out.println("Invalid Variable !");
			multiply();
			return;
		}
		if (test.checkSet(ch)) {
			System.out.println("Variable not set ");
			multiply();
			return;
		}
		System.out.println("Insert second "
				+ "operand variable name: A, B or C");
		c = s.next();
		char ch2 = c.charAt(0);
		if (ch2 != 'A' && ch2 != 'a' && ch2 != 'b'
				&& ch2 != 'B' && ch2 != 'c' && ch2 != 'C') {
			System.out.println("Invalid Variable !");
			multiply();
			return;
		}
		if (test.checkSet(ch2)) {
			System.out.println("Variable not set ");
			multiply();
			return;
		}
		test.multiply(ch, ch2);
		app();
		return;
	}

	/**.
	 * evaluate a poly
	 */
	public void evaluate() {
		Scanner s = new Scanner(System.in);
		System.out.println("Insert the variable name: A, B, C or R");
		String c;
		c = s.next();
		char ch = c.charAt(0);
		if (ch != 'A' && ch != 'a' && ch != 'b' && ch != 'B'
				&& ch != 'c' && ch != 'C'
				&& ch != 'r' && ch != 'R') {
			System.out.println("Invalid input !");
			evaluate();
			return;
		}
		if (test.checkSet(ch)) {
			System.out.println("Variable not set ");
			evaluate();
			return;
		}
		System.out.println("Enter the value of X :");
		float value = s.nextFloat();
		float eval = test.evaluatePolynomial(ch, value);
		System.out.printf("The Value in %c is %f", ch, eval);
		app();
		return;

	}

	/**.
	 * clear a poly
	 */
	public void clear() {
		Scanner s = new Scanner(System.in);
		System.out.println("Insert the variable name: A, B, C or R");
		String c;
		c = s.next();
		char ch = c.charAt(0);
		if (ch != 'A' && ch != 'a' && ch != 'b'
				&& ch != 'B' && ch != 'c' && ch != 'C'
				&& ch != 'r' && ch != 'R') {
			System.out.println("Invalid input !");
			clear();
			return;
		}
		if (test.checkSet(ch)) {
			System.out.println("Polynomial is already empty");
			return;
		}
		test.clearPolynomial(ch);
		app();
		return;
	}

}
