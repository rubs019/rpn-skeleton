package rpn.bus;

import rpn.consumer.Consumer;
import rpn.message.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBus implements Bus {

    private final Map<String, List<Consumer>> consumersByType = new HashMap<>();

    @Override
    public void publish(Message message) {
        List<Consumer> consumers = consumersByType.get(message.messageType());
        if(consumers==null)
            return;

        consumers.forEach(c -> c.receive(message));
    }

    @Override
    public void subscribe(String messageType, Consumer consumer) {
        List<Consumer> consumers = consumersByType.get(messageType);
        if(consumers == null) {
            consumers = new ArrayList<>();
            consumersByType.put(messageType, consumers);
        }
        consumers.add(consumer);
    }
}
