package Tuefteln.parser.function;

import Tuefteln.parser.exception.CalculatorException;

public final class Function implements Constants{

    private final String f_x;

    public Function(final String f_x) {
        this.f_x = f_x.trim().replaceAll(" ", "").toLowerCase();
    }

    public double getF_xo(final double xo) throws CalculatorException {
        return eval(f_x, xo);
    }

    public double eval(final String f_x, final double xi) throws CalculatorException {
        double value = 0;
        StringBuilder number = new StringBuilder();
        String function = "";
        boolean hasNumber = false;
        boolean hasFunction = false;

        for (int i = 0; i < f_x.length(); i++) {
            final char character = f_x.charAt(i);

            switch (character) {
                case '0', '1', '2', '3', '4', '5','6','7','8','9' -> {
                    hasNumber = true;
                    number.append(character);
                    if (i == (f_x.length() - 1)) {
                        value = Double.parseDouble(number.toString());
                        number = new StringBuilder();
                        hasNumber = false;
                    }
                }
                case '+' -> {
                    if (hasNumber) {
                        final double numb = Double.parseDouble(number.toString());
                        final String new_f_x = f_x.substring(i + 1);
                        value = numb + eval(new_f_x, xi);
                        i += new_f_x.length();
                        hasNumber = false;
                        number = new StringBuilder();
                    } else if (hasFunction) {
                        final String new_f_x = f_x.substring(i + 1);
                        value = eval(function, xi) + eval(new_f_x, xi);
                        i += new_f_x.length();
                        hasFunction = false;
                        function = "";
                    } else {
                        final String new_f_x = f_x.substring(i + 1);
                        value = value + eval(new_f_x, xi);
                        i += new_f_x.length();
                    }
                }
                case '*' -> {
                    if (hasNumber) {
                        final double numb = Double.parseDouble(number.toString());
                        final String new_f_x = nextFunction(f_x.substring(i + 1));
                        value = numb * eval(new_f_x, xi);
                        i += new_f_x.length();
                        hasNumber = false;
                        number = new StringBuilder();
                    } else if (hasFunction) {
                        final String new_f_x = nextFunction(f_x.substring(i + 1));
                        value = eval(function, xi) * eval(new_f_x, xi);
                        i += new_f_x.length();
                        hasFunction = false;
                        function = "";
                    } else {
                        final String new_f_x = nextFunction(f_x.substring(i + 1));
                        value = value * eval(new_f_x, xi);
                        i += new_f_x.length();
                    }
                }
                case '-' -> {
                    if (hasNumber) {
                        final double numb = Double.parseDouble(number.toString());
                        final String new_f_x = nextMinusFunction(f_x.substring(i + 1));
                        value = numb - eval(new_f_x, xi);
                        i += new_f_x.length();
                        hasNumber = false;
                        number = new StringBuilder();
                    } else if (hasFunction) {
                        final String new_f_x = nextMinusFunction(f_x.substring(i + 1));
                        value = eval(function, xi) - eval(new_f_x, xi);
                        i += new_f_x.length();
                        hasFunction = false;
                        function = "";
                    } else {
                        final String new_f_x = nextMinusFunction(f_x.substring(i + 1));
                        value = value - eval(new_f_x, xi);
                        i += new_f_x.length();
                    }
                }
                case '/' -> {
                    if (hasNumber) {
                        final double numb = Double.parseDouble(number.toString());
                        final String new_f_x = nextFunction(f_x.substring(i + 1));
                        value = numb / eval(new_f_x, xi);
                        i += new_f_x.length();
                        hasNumber = false;
                        number = new StringBuilder();
                    } else if (hasFunction) {
                        final String new_f_x = nextFunction(f_x.substring(i + 1));
                        value = eval(function, xi) / eval(new_f_x, xi);
                        i += new_f_x.length();
                        hasFunction = false;
                        function = "";
                    } else {
                        final String new_f_x = nextFunction(f_x.substring(i + 1));
                        value = value / eval(new_f_x, xi);
                        i += new_f_x.length();
                    }
                }
                case '^' -> {
                    if (hasNumber) {
                        final double numb = Double.parseDouble(number.toString());
                        final String new_f_x = nextFunction(f_x.substring(i + 1));
                        value = StrictMath.pow(numb, eval(new_f_x, xi));
                        i += new_f_x.length();
                        hasNumber = false;
                        number = new StringBuilder();
                    } else if (hasFunction) {
                        final String new_f_x = nextFunction(f_x.substring(i + 1));
                        value = StrictMath.pow(eval(function, xi), eval(new_f_x, xi));
                        i += new_f_x.length();
                        hasFunction = false;
                        function = "";
                    } else {
                        final String new_f_x = nextFunction(f_x.substring(i + 1));
                        value = StrictMath.pow(value, eval(new_f_x, xi));
                        i += new_f_x.length();
                    }
                }
                case'!' -> {
                    if (hasNumber) {
                        final double numb = Double.parseDouble(number.toString());
                        final String new_f_x = nextFunction(f_x.substring(i + 1));
                        value = factorial(numb);
                        i += new_f_x.length();
                        hasNumber = false;
                        number = new StringBuilder();
                    } else if (hasFunction) {
                        final String new_f_x = nextFunction(f_x.substring(i + 1));
                        value = factorial(eval(function, xi));
                        i += new_f_x.length();
                        hasFunction = false;
                        function = "";
                    } else {
                        final String new_f_x = nextFunction(f_x.substring(i + 1));
                        value = factorial(value);
                        i += new_f_x.length();
                    }
                }
                case '.' -> {
                    if (i == (f_x.length() - 1)) {
                        throw new CalculatorException("The function is not well-formed");
                    }
                    if (hasNumber && (number.length() > 0)) {
                        number.append(character);
                    }
                }
                case '(' -> {
                    if (i == (f_x.length() - 1)) {
                        throw new CalculatorException("The function is not well-formed");
                    }
                    final String new_f_x = f_x.substring(i + 1, nextBracket(f_x));
                    if (hasFunction) {
                        switch (function) {
                            case SIN -> value = StrictMath.sin(eval(new_f_x, xi));
                            case COS -> value = StrictMath.cos(eval(new_f_x, xi));
                            case TAN -> value = StrictMath.tan(eval(new_f_x, xi));
                            case SINH -> value = StrictMath.sinh(eval(new_f_x, xi));
                            case COSH -> value = StrictMath.cosh(eval(new_f_x, xi));
                            case TANH -> value = StrictMath.tanh(eval(new_f_x, xi));
                            case ASIN -> value = StrictMath.asin(eval(new_f_x, xi));
                            case ACOS -> value = StrictMath.acos(eval(new_f_x, xi));
                            case ATAN -> value = StrictMath.atan(eval(new_f_x, xi));
                            case LN -> value = StrictMath.log(eval(new_f_x, xi));
                            case LOG -> value = StrictMath.log10(eval(new_f_x, xi));
                            case SQRT -> value = StrictMath.sqrt(eval(new_f_x, xi));
                            case CBRT -> value = StrictMath.cbrt(eval(new_f_x, xi));
                            case ROOT -> value = nthRoot(eval(new_f_x.split(",")[0],xi)
                                    , (int) eval(new_f_x.split(",")[1],xi));
                            default -> throw new CalculatorException("The function is not well-formed");
                        }
                        hasFunction = false;
                        function = "";
                    } else {
                        value = eval(new_f_x, xi);
                    }
                    i += new_f_x.length() + 1;
                }
                case 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' -> { //isValidCharacter
                    function = function + character;
                    hasFunction = true;
                    if (i == (f_x.length() - 1)) {
                        if (Constants.E.equals(function)) {
                            value = StrictMath.E;
                        } else if (Constants.PI.equals(function)) {
                            value = StrictMath.PI;
                        } else if (function.length() == 1) {
                            value = xi;
                        } else {
                            throw new CalculatorException("function is not well defined");
                        }
                    }
                }
                case ')' -> throw new CalculatorException(" '(' is not finished ");
                default -> {
                    if (character != ' ') {
                        throw new CalculatorException("Invalid character:" + character);
                    }
                }
            }
        }
        return value;
    }

    /**
     * Next function.
     *
     * @param f_x the f x
     * @return the string
     * @throws CalculatorException the calculator exception
     */
    private String nextFunction (final String f_x) throws CalculatorException {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < f_x.length(); i++) {
            final char character = f_x.charAt(i);

            if (isValidNumericAndCharacter(character)) {
                result.append(character);
            } else if (character == '+' || character == '*' || character == '-' || character == '/') {
                i = f_x.length();
            } else if (character == '.' || character == '^' || character == '!') {
                result.append(character);
            } else {
                i = getI(f_x, result, i, character);
            }
        }
        return result.toString();
    }

    private int getI (String f_x, StringBuilder result, int i, char character) throws CalculatorException {
        if (character == '(') {
            final String new_f_x = f_x.substring(i, nextBracket(f_x) + 1);
            result.append(new_f_x);
            i = (i + new_f_x.length()) - 1;
        } else if (character == ')') {
            throw new CalculatorException(" '(' is not finished ");
        } else if (character == ' ') {
            result.append(character);
        } else {
            throw new CalculatorException("Invalid character:" + character);
        }
        return i;
    }

    /**
     * Next minus function.
     *
     * @param f_x the f x
     * @return the string
     * @throws CalculatorException the calculator exception
     */
    private String nextMinusFunction (final String f_x) throws CalculatorException {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < f_x.length(); i++) {
            final char character = f_x.charAt(i);

            if (isValidNumericAndCharacter(character)) {
                result.append(character);
            } else if (character == '+' || character == '-') {
                i = f_x.length();
            } else if (character == '*' || character == '/' || character == '.' || character == '^') {
                result.append(character);
            } else i = getI(f_x, result, i, character);
        }
        return result.toString();
    }

    /**
     * isValidNumericAndCharacter.
     *
     * @param character the character
     * @return true, if is valid numeric and character
     */
    private boolean isValidNumericAndCharacter (final char character) {
        return (character >= 'a' && character <= 'z') || (character >= '0' && character <= '9');
    }

    /**
     * nextBracket.
     *
     * @param f_x f(x)
     * @return the int
     * @throws CalculatorException the calculator exception
     */
    private int nextBracket (final String f_x) throws CalculatorException {
        int result = 0;
        int count = 0;
        for (int i = 0; i < f_x.length(); i++) {
            final char character = f_x.charAt(i);
            if (character == '(') {
                result = i;
                count++;
            } else if (character == ')') {
                result = i;
                count--;
                if (count == 0) {
                    return i;
                }
            } else {
                result = i;
            }
        }
        if (count != 0) {
            throw new CalculatorException("( is not finished");
        }
        return result;
    }
}
