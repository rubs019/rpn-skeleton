package rpn.message;

public class ResultMessage implements Message {
    public static final String MESSAGE_TYPE = "result";

    @Override
    public String messageType() { return MESSAGE_TYPE; }


}
