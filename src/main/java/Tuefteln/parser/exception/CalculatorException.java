package Tuefteln.parser.exception;

import java.io.Serial;

public class CalculatorException extends Exception {

	@Serial
	private static final long serialVersionUID = 6235428117353457356L;

	public CalculatorException(final String message) {
		super(message);
	}
}
