package rpn.consumer;

import rpn.bus.Bus;
import rpn.message.*;
import rpn.operators.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RPNCalculator implements Consumer {
    private Bus bus;
    private Stack<Float> stack = new Stack<>();
    private Map<String, Operator> commands = new HashMap<>();

    public RPNCalculator(Bus bus) {
        this.bus = bus;

        commands.put("+", new Addition(bus));
        commands.put("-", new Soustraction());
        commands.put("/", new Division());
        commands.put("*", new Multiplication());
    }

    @Override
    public void receive(Message message) {
        if (message.messageType().equals(TokenMessage.MESSAGE_TYPE)) {

            TokenMessage tokenMessage = (TokenMessage) message;
            String token = tokenMessage.getToken();

            if (commands.containsKey(token)) {
                bus.publish(new OperatorMessage(tokenMessage.getExpressionId(), token, stack));
            } else {
                stack.push(Float.parseFloat(token));
            }

        }

        if (message.messageType().equals(OperatorMessage.MESSAGE_TYPE)) {
            OperatorMessage operatorMessage = (OperatorMessage) message;

            stack.push(commands.get(operatorMessage.getOperator()).calc(stack.pop(), stack.pop()));
        }

        if (message.messageType().equals(EndOfToken.MESSAGE_TYPE)) {
            EndOfToken endOfToken = (EndOfToken) message;
            bus.publish(new ResultMessage(stack, endOfToken.getExpressionId()));
        }

        if (message.messageType().equals(ResultMessage.MESSAGE_TYPE)) {
            this.stack = stack;
        }
    }

    public Float result() {
        return stack.pop();
    }
}
