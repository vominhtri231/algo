package mathevaluation;

import java.math.BigDecimal;
import java.util.*;

public class Evaluator {

    private static final Map<String, Operation> tokenToOperation = new HashMap<String, Operation>() {{
        put("+", Operation.PLUS);
        put("-", Operation.MINUS);
        put("X", Operation.MULTIPLE);
        put("/", Operation.DIVIDE);
    }};

    private static final Set<String> availableOperationTokens = tokenToOperation.keySet();

    public BigDecimal evaluate(String mathExpression) {
        Queue<String> infix = expressionToInfix(mathExpression);
        Queue<String> postfix = convertToPostfix(infix);
        return evaluate(postfix);
    }

    private BigDecimal evaluate(Collection<String> postfix) {
        Stack<BigDecimal> values = new Stack<>();
        for (String token : postfix) {

            if (availableOperationTokens.contains(token)) {
                BigDecimal b = values.pop();
                BigDecimal a = values.pop();
                values.push(tokenToOperation.get(token).apply(a, b));
            } else {
                values.push(new BigDecimal(token));
            }
        }

        return values.peek();
    }

    private Queue<String> convertToPostfix(Collection<String> infix) {
        Stack<String> operators = new Stack<>();
        Queue<String> output = new LinkedList<>();

        for (String token : infix) {

            if (availableOperationTokens.contains(token)) {
                while (!operators.isEmpty()
                        && !operators.peek().equals("(")
                        && tokenToOperation.get(operators.peek()).precedence >= tokenToOperation.get(token).precedence) {
                    output.add(operators.pop());
                }
                operators.push(token);
                continue;
            }

            if (token.equals("(")) {
                operators.push(token);
                continue;
            }

            if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                operators.pop();
                continue;
            }

            output.add(token);
        }

        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        return output;
    }

    private Queue<String> expressionToInfix(String expression) {
        LinkedList<String> output = new LinkedList<>();
        char[] tokens = expression.toCharArray();
        boolean previousDigit = false;

        for (char token : tokens) {
            if (Character.isWhitespace(token)) {
                continue;
            }

            if (Character.isDigit(token)) {
                if (previousDigit) {
                    output.addLast(output.removeLast() + token);
                } else {
                    output.addLast("" + token);
                    previousDigit = true;
                }
                continue;
            }

            output.addLast("" + token);
            previousDigit = false;
        }

        return output;
    }

    private enum Operation {
        PLUS(1) {
            @Override
            BigDecimal apply(BigDecimal a, BigDecimal b) {
                return a.add(b);
            }
        },
        MINUS(1) {
            @Override
            BigDecimal apply(BigDecimal a, BigDecimal b) {
                return a.subtract(b);
            }
        },
        MULTIPLE(2) {
            @Override
            BigDecimal apply(BigDecimal a, BigDecimal b) {
                return a.multiply(b);
            }
        },
        DIVIDE(2) {
            @Override
            BigDecimal apply(BigDecimal a, BigDecimal b) {
                return a.divide(b);
            }
        };

        int precedence;

        Operation(int precedence) {
            this.precedence = precedence;
        }

        abstract BigDecimal apply(BigDecimal a, BigDecimal b);
    }

    public static void main(String[] args) {
        Evaluator evaluator = new Evaluator();

        System.out.println(evaluator.evaluate("12 X (3 /(2+3) X (4 - 9)) + 89"));
    }
}
