package rpn.message;

import java.util.Stack;

public class OperatorMessage implements Message {
    public static final String MESSAGE_TYPE = "operatorMessage";
    private Stack<Float> stack;
    private String id;
    private String operator;

    public OperatorMessage(String id, String operator, Stack<Float> stack) {
        this.stack = stack;
        this.id = id;
        this.operator = operator;
    }

    public Stack<Float> getStack() {
        return stack;
    }

    public String getId() {
        return id;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String messageType() { return MESSAGE_TYPE; }


}
