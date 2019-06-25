package rpn.message;

public class OperandeMessage implements Message {
    public static final String MESSAGE_TYPE = "operandeMessage";

    @Override
    public String messageType() { return MESSAGE_TYPE; }
}
