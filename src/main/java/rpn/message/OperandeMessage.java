package rpn.message;

public class OperandeMessage implements Message {
    private static final String MESSAGE_TYPE = "operand";

    @Override
    public String messageType() { return MESSAGE_TYPE; }
}
