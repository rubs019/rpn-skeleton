package rpn.bus;

import rpn.consumer.Consumer;
import rpn.message.Message;

import java.util.ArrayList;

public interface Bus {
    void publish(Message message);
    void subscribe(String eventType, Consumer consumer);
}
