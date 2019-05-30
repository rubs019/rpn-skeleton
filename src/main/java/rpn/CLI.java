package rpn;

public class CLI {
    public static void main(String[] args) {
        String expression = String.join(" ", args);

        Float result = evaluate(expression);
        System.out.println("> " + result);
    }

    static Float evaluate(String expression) {
        if (expression.isEmpty()) { throw new IllegalArgumentException("You must pass some arguments"); }

        Calculatrice calc = new Calculatrice();

        System.out.println("About to evaluate '" + expression + "'");

        String[] cleanExpression = expression.trim().split( "\\s+"); // Supprime les espaces et convertir en array

        return calc.makeCalcul(cleanExpression);
    }
}
