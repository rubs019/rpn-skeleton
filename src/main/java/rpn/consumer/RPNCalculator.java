package rpn.consumer;

import rpn.bus.Bus;
import rpn.message.EndOfToken;
import rpn.message.Message;
import rpn.message.OperatorMessage;
import rpn.message.ResultMessage;
import rpn.operators.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RPNCalculator implements Consumer {
    private Bus bus;
    private Stack<Double> stack = new Stack<>();
    private Map<String, Operator> commands = new HashMap<>();

    public RPNCalculator(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void receive(Message message) {
        if (message.messageType().equals(OperatorMessage.MESSAGE_TYPE)) {
            bus.publish(message);
        }

        if (message.messageType().equals(EndOfToken.MESSAGE_TYPE)) {
            System.out.println(stack.pop().toString());
        }
    }

    public void receive(Message message, Stack<Double> stack) {
        if (message.messageType().equals(ResultMessage.MESSAGE_TYPE)) {
            this.stack = stack;
        }
    }

    public Stack<Double> getStack() {
        return stack;
    }
}
