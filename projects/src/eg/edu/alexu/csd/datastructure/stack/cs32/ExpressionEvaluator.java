package eg.edu.alexu.csd.datastructure.stack.cs32;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**.
 * @author Sohayla Mohamed
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
	/**.
	 * this function checks if the character is an operator or not
	 *
	 * @param op
	 *            : a char from a string
	 * @return true if it's an operator ,false if not
	 */
	public boolean isoperators(final char op) {
		if (op == '+' || op == '-'
				|| op == '/' || op == '*'
				|| op == '(' || op == ')') {
			return true;
		}
		return false;
	}

	/**.
	 * this function returns the precedence of the operator
	 *
	 * @param c
	 *            : an operator
	 * @return an int that behave as
	 * the precedence or the rank of the operator
	 */
	public int precedence(final char c) {
		final int n1 = 5;
		final int n2 = 6;
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 0;
		case ')':
			return n1;
		default:
			return n2;
		}
	}

	/**.
	 * this function checks if a string have an unary operator or not
	 *
	 * @param str
	 *            : a string
	 * @return true if there is an unary operator, false if not
	 */
	public boolean unary(final String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			char c = str.charAt(i);
			char n = str.charAt(i + 1);
			if (isoperators(n) && isoperators(c)
			&& c != ' ' && n != ' '
			&& c != '(' && c != ')' && n != '('
			&& n != ')') {
				return true;
			}
		}
		return false;
	}

	/**.
	 * Takes a symbolic/numeric infix expression as input and converts it to
	 * postfix notation.
	 *  There is no assumption on spaces between terms or the
	 * length of the term (e.g., two digits symbolic or numeric term)
	 *
	 * @param expression
	 *            infix expression
	 * @return postfix expression
	 */
	public String infixToPostfix(final String expression) {

		if (expression == null || expression.length() == 0) {
			throw new RuntimeException();
		}
		String str = "";
		str = expression.replaceAll(" ", "");
		if (unary(str)) {
			throw new RuntimeException();
		}

		if ((isoperators(str.charAt(0)) && str.charAt(0) != '(')
				|| (isoperators(str.charAt(str.length() - 1))
				&& str.charAt(str.length() - 1) != '(')) {
			throw new RuntimeException();
		}

		int i = 0;

		char c;
		StringBuilder temp = new StringBuilder();
		StringBuilder output = new StringBuilder();
		Stack oper = new Stack();
		while (i < str.length()) {

			if (!isoperators(str.charAt(i))) {

				while (!isoperators(str.charAt(i))) {

					temp.append(str.charAt(i));
					i++;
					if (i >= str.length()) {
						break;
					}
				}

				output.append(temp);
				output.append(' ');
				temp.setLength(0);
				if (i >= str.length()) {
					break;
				}
			}
			c = str.charAt(i);
			if (isoperators(c)) {

				if (c == '(') {
					oper.push(c);
					i++;
				} else if (c == ')') {

			while ((char) oper.peek() != '(' && !oper.isEmpty()) {
					output.append((char) oper.pop());
						output.append(' ');
					}
					if ((char) oper.stack.get(0) == '(') {
						oper.stack.remove(0);
					}

					i++;

				} else if (oper.isEmpty()) {
					oper.push(c);
					i++;
				} else if (precedence(c)
		     	<= precedence((char) oper.peek())) {
					while (precedence(c)
					<= precedence((char) oper.peek())) {
					output.append((char) oper.pop());
						output.append(' ');
						if (oper.isEmpty()) {
							break;
						}
					}
					oper.push(c);
					i++;
				} else {
					oper.push(c);
					i++;
				}
			}
		}
		if (oper.stack.contains('(')) {
			throw null;
		}
		while (!oper.isEmpty()) {
			output.append((char) oper.pop());
			output.append(' ');
		}
		String post = output.toString();
		post = post.substring(0, post.length() - 1);
		return post;
	}

	/**.
	 * it carries a specific operation
	 *
	 * @param no1
	 *            the first operand
	 * @param no2
	 *            the second operand
	 * @param op
	 *            the operator
	 * @return the operation evaluated value
	 */
	public float oper(final float no1, final float no2, final char op) {
		switch (op) {
		case '+':
			return no2 + no1;
		case '-':
			return no2 - no1;
		case '*':
			return no1 * no2;
		case '/':
			return no2 / no1;
		default:
			throw new RuntimeException();
		}
	}

	/**.
	 * checks if the string have a sympol that is not a vaid operator
	 *
	 * @param expression
	 *            postfix expression
	 * @return true if it does contain an invalid sympol, false if not
	 */
	public boolean sympolic(final String expression) {
		int sympol = 0;
		for (int i = 0; i < expression.length(); i++) {
			switch (expression.charAt(i)) {
			case '0':
				break;
			case ' ':
				break;
			case '1':
				break;
			case '2':
				break;
			case '3':
				break;
			case '4':
				break;
			case '5':
				break;
			case '6':
				break;
			case '7':
				break;
			case '8':
				break;
			case '9':
				break;
			default: if (!isoperators(expression.charAt(i))) {
					sympol = 1;
					break;
				} else {
					break;
				}
			}
		}
		return sympol > 0;
	}

	/**.
	 * Evaluate a postfix numeric expression, with a single space separator
	 *
	 * @param expression
	 *            postfix expression
	 * @return the expression evaluated value
	 */
	public int evaluate(final String expression) {
		if (expression == null || expression.length() == 0) {
			throw null;
		}
		if (sympolic(expression)) {
			throw null;
		}

		int i = 0;
		Stack num = new Stack();
		int sum = 0;
		float temp = 0;
		float f = 0;
		while (i < expression.length()) {

			if (expression.charAt(i) == ' ') {
				while (expression.charAt(i) == ' ') {
					i++;
				}
			}
			if (!isoperators(expression.charAt(i))
					&& expression.charAt(i) != '('
					&& expression.charAt(i) != ')') {
			f = Character.getNumericValue(expression.charAt(i));
				i++;
				final int in = 10;
				int g = in;
				while (!isoperators(expression.charAt(i))
						&& expression.charAt(i) != '('
						&& expression.charAt(i) != ')'
					&& expression.charAt(i) != ' ') {

					f = f * g
					+ Character.getNumericValue(
						expression.charAt(i));
					i++;
				}
				num.push(f);
			} else if (isoperators(expression.charAt(i))
					&& expression.charAt(i) != '('
					&& expression.charAt(i) != ')') {
				float no1 = (float) num.pop();
				if (num.isEmpty()) {
					throw null;
				}
				float no2 = (float) num.pop();
				num.push(oper(no1, no2, expression.charAt(i)));
				i++;

			} else {
				throw new RuntimeException();
			}
		}
		if (num.size() == 1) {
			temp = (float) num.pop();
		} else if (!num.isEmpty()) {
			throw new RuntimeException();

		} else if (num.isEmpty()) {
			throw new RuntimeException();
		}
		sum = (int) temp;
		return sum;

	}

}
