package Tuefteln.parser.function;

import Tuefteln.parser.exception.CalculatorException;

public interface Constants {
	String SIN = "sin";
	String COS = "cos";
	String SINH = "sinh";
	String COSH = "cosh";
	String TAN = "tan";String TANH = "tanh";
	String ASIN = "asin";
	String ACOS = "acos";
	String ATAN = "atan";
	String E = "e";
	String PI = "pi";
	String LN = "ln";
	String LOG = "log";
	String SQRT = "sqrt";
	String CBRT = "cbrt";
	String ROOT = "root";

	default double factorial(final double number) throws CalculatorException {
		if (number == 1) {
			return 1;
		} else if (number == 0) {
			throw new CalculatorException("Factorial of 0 is undefined");
		} else {
			return number * factorial(number - 1);
		}
	}

	default double nthRoot(final double d1, final int magnitude) {
		if (magnitude == 0) {
			// If the magnitude is 0, return 1 (any number to the 0th power is 1)
			return 1;
		} else if (magnitude < 0) {
			// If the magnitude is negative, return NaN (the result is undefined)
			return Double.NaN;
		}
		// Initialize the result to an initial guess (such as the number divided by the magnitude)
		double result = Math.pow(d1, 1.0 / magnitude);
		// Use a loop to refine the result until it is accurate enough
		double error = Math.pow(10, -10); // The desired error tolerance
		double lastResult; // The result from the previous iteration
		do {
			lastResult = result;
			result = ((magnitude - 1.0) * lastResult + d1 / Math.pow(lastResult, magnitude - 1.0)) / magnitude;
		} while (Math.abs(result - lastResult) > error);
		return result;
	}
}
