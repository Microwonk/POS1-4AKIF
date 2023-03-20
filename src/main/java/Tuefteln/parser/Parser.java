package Tuefteln.parser;

import Tuefteln.parser.exception.CalculatorException;
import Tuefteln.parser.function.Function;

public class Parser {

	public static double simpleEval(final String function) {
		double result = 0;
		final Function f_x;

		if (function != null && !function.isEmpty()) {
			f_x = new Function(function);
			try {
				result = f_x.getF_xo(1);
			} catch (final CalculatorException e) {
				System.out.println("mau");
			}
		}
		return result;
	}
}
