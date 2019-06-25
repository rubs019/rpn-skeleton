package rpn;

import org.junit.Assert;
import org.junit.Test;
import rpn.bus.InMemoryBus;
import rpn.consumer.RPNCalculator;
import rpn.consumer.TokenizerConsumer;
import rpn.message.*;

import java.util.UUID;

public class BusTest {

    @Test
    public void should_set_correctly_expression_message() {

        ExpressionMessage expressionMessage = new ExpressionMessage("26", "1");

        Assert.assertEquals("26", expressionMessage.expression());
        Assert.assertEquals("1", expressionMessage.expressionId());
    }

    @Test
    public void should_calculate() {
        InMemoryBus bus = new InMemoryBus();
        bus.subscribe(ExpressionMessage.MESSAGE_TYPE, new TokenizerConsumer(bus));

        RPNCalculator calculator = new RPNCalculator(bus);

        bus.subscribe(TokenMessage.MESSAGE_TYPE, calculator);
        bus.subscribe(EndOfToken.MESSAGE_TYPE, calculator);
        bus.subscribe(OperatorMessage.MESSAGE_TYPE, calculator);
        bus.subscribe(OperandeMessage.MESSAGE_TYPE, calculator);

        bus.subscribe(ResultMessage.MESSAGE_TYPE, calculator);


        String expressionId = UUID.randomUUID().toString();
        bus.publish(new ExpressionMessage("1 2 +", expressionId));

        Assert.assertEquals(calculator.result(), new Float(3));
    }


}
