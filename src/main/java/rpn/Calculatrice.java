package rpn;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Stack;

public class Calculatrice {
    Stack stack = new Stack();
    public Long makeCalcul(String[] expressions) {

        for (String expression : expressions) {
            if (expression.equals("+")) {
                Symbol addition = new Addition();
                Long result = addition.calc(stack.pop(), stack.pop());
                stack.push(result);
                continue;
            }

            if (expression.equals("-")) {
                Symbol soustraction = new Soustraction();
                Long result = soustraction.calc(stack.pop(), stack.pop());
                stack.push(result);
                continue;
            }

            if (expression.equals("*")) {
                Symbol multiplication = new Multiplication();
                Long result = multiplication.calc(stack.pop(), stack.pop());
                stack.push(result);
                continue;
            }

            if (expression.equals("/")) {
                Symbol division = new Division();
                Long result = division.calc(stack.pop(), stack.pop());
                stack.push(result);
                continue;
            }

            stack.push(Long.parseLong(expression));
        }
        Long finalResult = Long.parseLong(stack.pop().toString());

        return finalResult;
    }
}
