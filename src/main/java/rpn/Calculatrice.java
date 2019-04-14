package rpn;

import java.util.Stack;

public class Calculatrice {
    private Stack<Operande> stack = new Stack<>();
    public Float makeCalcul(String[] expressions) {

        for (String expression : expressions) {
            if (expression.equals("+")) {
                stack.push(new Addition(stack.pop(), stack.pop()).calc());
                continue;
            }

            if (expression.equals("-")) {
                stack.push(new Soustraction(stack.pop(), stack.pop()).calc());
                continue;
            }

            if (expression.equals("*")) {
                stack.push(new Multiplication(stack.pop(), stack.pop()).calc());
                continue;
            }

            if (expression.equals("/")) {
                stack.push(new Division(stack.pop(), stack.pop()).calc());
                continue;
            }

            stack.push(new Operande(Float.parseFloat(expression)));
        }

        return stack.pop().getValue();
    }
}
