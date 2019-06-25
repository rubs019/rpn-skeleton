package rpn.message;

public class OperandeMessage implements Message {
    private static final String MESSAGE_TYPE = "operandeMessage";

    @Override
    public String messageType() { return MESSAGE_TYPE; }
}
