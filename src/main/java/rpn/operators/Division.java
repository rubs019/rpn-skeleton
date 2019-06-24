package rpn.operators;

import static java.lang.Math.abs;

public class Division implements Operator {
    @Override
    public float calc(float operande1, float operande2) {
        if(abs(operande1 - 0.0) < 10^-6){
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        return operande2 / operande1;
    }
}
