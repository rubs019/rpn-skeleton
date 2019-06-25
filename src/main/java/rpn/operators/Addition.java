package rpn.operators;

import rpn.bus.Bus;
import rpn.message.Message;
import rpn.message.OperatorMessage;

public class Addition implements Operator {
    public final static String MESSAGE_TYPE = "+";
    private final Bus bus;

    public Addition(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void receive(Message message) {
        OperatorMessage operatorMessage = (OperatorMessage) message;

        // Not Implemented
    }

    @Override
    public float calc(float operande1, float operande2) {
        return operande1 + operande2;
    }
}
