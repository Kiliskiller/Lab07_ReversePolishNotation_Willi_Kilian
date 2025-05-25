package postfix;

import stack.Underflow;

import java.util.LinkedList;

public class Postfix {

	/**
	* Syntax has to be in Postfix for this method
	*/
	public static double evaluate(String[] expression) throws Underflow {
//		if (expression == null || expression.trim().isEmpty()) {
//			throw new IllegalArgumentException("Expression cannot be null or empty.");
//		}
		LinkedList<Double> Stack = new LinkedList<>();
			for(int o = 0; o<expression.length;o++){
				if(isNumber(expression[o])){
				Stack.push(Double.parseDouble(expression[o]));}
				else{
					break;
				}
			}
		double b = (Double) Stack.pop();
		double a = (Double) Stack.pop();
		double result = applyOperator(a, b, expression[2]);

		//String[] tokens = expression.trim().split("\\s+");
//		for (String token : tokens) {
//			if (isNumber(token)) {
//				Stack.push(Double.parseDouble(token));
//			} else if (isOperator(token)) {
//				if (Stack.isEmpty()) throw new IllegalArgumentException("unfinished expression: missing operands.");
//				double b = (Double) Stack.pop();
//				if (Stack.isEmpty()) throw new IllegalArgumentException("unfinished expression: missing operands.");
//				double a = (Double) Stack.pop();
//				double result = applyOperator(a, b, token);
//				Stack.push(result);
//			} else {
//				throw new IllegalArgumentException("Invalid token: " + token);
//			}
//		}
//		if (Stack.isEmpty()) {
//			throw new IllegalArgumentException("unfinished expression: no result.");
//		}
//		double finalResult = (Double) Stack.pop();
//		if (!Stack.isEmpty()) {
//			throw new IllegalArgumentException("unfinished expression: leftover operands.");
//		}
		return result;
	}

	public static boolean isNumber(String token) {
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
