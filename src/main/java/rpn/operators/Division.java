package rpn.operators;

public class Division implements Operator {
    @Override
    public float calc(float operande1, float operande2) {
        if(operande1 == 0 || operande2 == 0){
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        return operande2 / operande1;
    }
}
