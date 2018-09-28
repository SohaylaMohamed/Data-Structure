package eg.edu.alexu.csd.datastructure.stack.cs32;

public class Testapp {

	public static void main(String[] args) {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String post = test.infixToPostfix( "5*6+18/2");
		System.out.println(post);

		int eval = test.evaluate(post);
		System.out.println(eval);
	}

}
