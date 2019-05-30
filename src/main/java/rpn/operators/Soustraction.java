package rpn.operators;

public class Soustraction implements Operator {
    @Override
    public float calc(float operande1, float operande2) {
        return operande2 - operande1;
    }
}
