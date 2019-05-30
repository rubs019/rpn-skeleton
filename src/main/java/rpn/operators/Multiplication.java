package rpn.operators;

public class Multiplication implements Operator {
    @Override
    public float calc(float operande1, float operande2) {
        return operande1 * operande2;
    }
}
