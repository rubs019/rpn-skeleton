package rpn;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        Float result = evaluate(expression);
        System.out.println("> " + result);
    }

    static Float evaluate(String expression) {
        Calculatrice calc = new Calculatrice();

        String[] cleanExpression = expression.trim().split( "\\s+"); // Supprime les espaces et convertir en array

        return calc.makeCalcul(cleanExpression);
    }
}
