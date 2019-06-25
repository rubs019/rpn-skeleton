package rpn;

import org.junit.Assert;
import org.junit.Test;
import rpn.message.ExpressionMessage;

public class BusTest {

    @Test
    public void should_return_true() {

        ExpressionMessage expressionMessage = new ExpressionMessage("26", "1");

        Assert.assertEquals("24", expressionMessage.expression());
        Assert.assertEquals("1", expressionMessage.expressionId());
    }
}
