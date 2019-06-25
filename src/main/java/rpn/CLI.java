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
    }
}
