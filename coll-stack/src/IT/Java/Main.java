package IT.Java;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		String exp = "x + 2 * (y - 5)";
		SuffixExpression se = compile(exp);
		Map<String, Integer> env = Map.of("x", 1, "y", 9);
		int result = se.execute(env);
		System.out.println(env);
		System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "Y" : "N"));
	}

	static SuffixExpression compile(String exp) {
		// TODO:
		return new SuffixExpression();
	}
}

class SuffixExpression {
	int execute(Map<String, Integer> env) {
		// TODO:
		return 0;
	}
}
