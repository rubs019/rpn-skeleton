package rpn.message;

public class ResultMessage implements Message {
    public static final String MESSAGE_TYPE = "resultMessage";

    @Override
    public String messageType() { return MESSAGE_TYPE; }


}
