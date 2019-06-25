package rpn.operators;

import rpn.message.Message;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Multiplication implements Operator {
    @Override
    public float calc(float operande1, float operande2) {
        return operande1 * operande2;
    }

    @Override
    public void receive(Message message) {
        throw new NotImplementedException();
    }
}
