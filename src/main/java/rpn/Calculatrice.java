package rpn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculatrice {
    private Stack<Float> stack = new Stack<>();
    private Map<String, Operator> commands = new HashMap<>();

    public Float makeCalcul(String[] expressions) {

        commands.put("+", new Addition());
        commands.put("-", new Soustraction());
        commands.put("/", new Division());
        commands.put("*", new Multiplication());


        for (String expression : expressions) {
            if (commands.containsKey(expression)) {
                stack.push(commands.get(expression).calc(stack.pop(), stack.pop()));
                continue;
            }

            stack.push(Float.parseFloat(expression));
        }

        return stack.pop();
    }
}
