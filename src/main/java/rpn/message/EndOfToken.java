package rpn.message;

public class EndOfToken implements Message {
    public static final String MESSAGE_TYPE = "endOfToken";
    private final String expressionId;

    public EndOfToken(String newExpressionId) {
        this.expressionId = newExpressionId;
    }

    @Override
    public String messageType() {
        return MESSAGE_TYPE;
    }

    public String getExpressionId() { return expressionId; }
}
