package rpn.operators;

import rpn.message.Message;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Soustraction implements Operator {
    @Override
    public float calc(float operande1, float operande2) {
        return operande2 - operande1;
    }

    @Override
    public void receive(Message message) {
        throw new NotImplementedException();
    }
}
