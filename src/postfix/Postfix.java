package postfix;

import stack.LinkedListStack;
import stack.Stack;
import stack.Underflow;
public class Postfix {
	public static double evaluate(String expression) throws Underflow {
		if (expression == null || expression.trim().isEmpty()) {
			throw new IllegalArgumentException("Expression cannot be null or empty.");
		}
		LinkedListStack<Double> stack = new LinkedListStack<>();
		String[] tokens = expression.trim().split("\\s+");
		for (String token : tokens) {
			if (isNumber(token)) {
				stack.push(Double.parseDouble(token));
			} else if (isOperator(token)) {
				if (stack.isEmpty()) throw new IllegalArgumentException("Malformed expression: missing operands.");
				double b = (Double) stack.pop();
				if (stack.isEmpty()) throw new IllegalArgumentException("Malformed expression: missing operands.");
				double a = (Double) stack.pop();
				double result = applyOperator(a, b, token);
				stack.push(result);
			} else {
				throw new IllegalArgumentException("Invalid token: " + token);
			}
		}
		if (stack.isEmpty()) {
			throw new IllegalArgumentException("Malformed expression: no result.");
		}
		double finalResult = (Double) stack.pop();
		if (!stack.isEmpty()) {
			throw new IllegalArgumentException("Malformed expression: leftover operands.");
		}
		return finalResult;
	}
	private static boolean isNumber(String token) {
		try {
			Double.parseDouble(token);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	private static boolean isOperator(String token) {
		return token.length() == 1 && "+-*/".contains(token);
	}
	private static double applyOperator(double a, double b, String op) {
		return switch (op) {
			case "+" -> a + b;
			case "-" -> a - b;
			case "*" -> a * b;
			case "/" -> {
				if (b == 0) throw new ArithmeticException("Division by zero.");
				yield a / b;
			}
			default -> throw new IllegalArgumentException("Unknown operator: " + op);
		};
	}
}
