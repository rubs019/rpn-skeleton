package rpn.operators;

public class Addition implements Operator {
    @Override
    public float calc(float operande1, float operande2) {
        return operande1 + operande2;
    }
}
