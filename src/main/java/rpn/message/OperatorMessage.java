package rpn.message;

public class OperatorMessage implements Message {
    public static final String MESSAGE_TYPE = "operator";

    @Override
    public String messageType() { return MESSAGE_TYPE; }
}
