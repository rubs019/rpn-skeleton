package rpn.operators;

import rpn.message.Message;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Division implements Operator {
    @Override
    public float calc(float operande1, float operande2) {
        if(abs(operande1 - 0.0) < pow(10, -6)){
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        return operande2 / operande1;
    }

    @Override
    public void receive(Message message) {
        throw new NotImplementedException();
    }
}
