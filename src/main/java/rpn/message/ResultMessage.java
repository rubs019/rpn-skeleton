package rpn.message;

import java.util.Stack;

public class ResultMessage implements Message {
    public static final String MESSAGE_TYPE = "result";

    private final Stack<Float> result;
    private final String expressionId;

    public ResultMessage(Stack<Float> result, String expressionId) {
        this.result = result;
        this.expressionId = expressionId;
    }

    @Override
    public String messageType() { return MESSAGE_TYPE; }

    public Stack<Float> getResult() {
        return result;
    }

    public String getExpressionId() {
        return expressionId;
    }
}
