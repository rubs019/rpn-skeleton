package rpn;

import rpn.bus.InMemoryBus;
import rpn.consumer.RPNCalculator;
import rpn.consumer.TokenizerConsumer;
import rpn.message.EndOfToken;
import rpn.message.ExpressionMessage;
import rpn.message.TokenMessage;

import java.util.UUID;

public class CLI {
    public static void main(String[] args) {
        InMemoryBus bus = new InMemoryBus();

        RPNCalculator calculator = new RPNCalculator(bus);

        bus.subscribe(TokenMessage.MESSAGE_TYPE, calculator);
        bus.subscribe(EndOfToken.MESSAGE_TYPE, calculator);


        String expressionId = UUID.randomUUID().toString();
        bus.publish(new ExpressionMessage("1 2 +", expressionId));
    }
}
