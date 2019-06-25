package rpn;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import rpn.bus.InMemoryBus;
import rpn.consumer.RPNCalculator;
import rpn.consumer.TokenizerConsumer;
import rpn.message.*;

public class BusTest {

    private InMemoryBus bus;
    private String expressionId = "1";
    private RPNCalculator calculator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init() {
        bus = new InMemoryBus();
        bus.subscribe(ExpressionMessage.MESSAGE_TYPE, new TokenizerConsumer(bus));

        calculator = new RPNCalculator(bus);

        bus.subscribe(TokenMessage.MESSAGE_TYPE, calculator);
        bus.subscribe(EndOfToken.MESSAGE_TYPE, calculator);
        bus.subscribe(OperatorMessage.MESSAGE_TYPE, calculator);
        bus.subscribe(OperandeMessage.MESSAGE_TYPE, calculator);

        bus.subscribe(ResultMessage.MESSAGE_TYPE, calculator);
    }

    @Test
    public void should_set_correctly_expression_message() {

        ExpressionMessage expressionMessage = new ExpressionMessage("26", "1");

        Assert.assertEquals("26", expressionMessage.expression());
        Assert.assertEquals("1", expressionMessage.expressionId());
    }

    @Test
    public void should_evaluate_division_by_zero() {
        thrown.expect(IllegalArgumentException.class);
        bus.publish(new ExpressionMessage("0 0 /", expressionId));
        calculator.result();
    }

    @Test
    public void should_calculate_a_simple_addition() {

        bus.publish(new ExpressionMessage("1 2 +", "1"));

        Assert.assertEquals(calculator.result(), new Float(3));
    }

    @Test
    public void should_evaluate_more_complex_addition() {

        bus.publish(new ExpressionMessage("2 3 5 + +", "1"));
        Assert.assertEquals(calculator.result(), new Float(10));
    }

    @Test
    public void should_evaluate_single_digit_constant() {
        bus.publish(new ExpressionMessage("5", expressionId));
        Assert.assertEquals(calculator.result(), new Float(5));
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        bus.publish(new ExpressionMessage("17", expressionId));
        Assert.assertEquals(calculator.result(), new Float(17));
    }

    @Test
    public void should_evaluate_simple_addition() {
        bus.publish(new ExpressionMessage("17 5 +", expressionId));
        Assert.assertEquals(calculator.result(), new Float(22));
    }

    @Test
    public void should_evaluate_simple_substraction() {
        bus.publish(new ExpressionMessage("2 1 -", expressionId));
        Assert.assertEquals(calculator.result(), new Float(1));
    }

    @Test
    public void should_evaluate_more_complex_substraction() {
        bus.publish(new ExpressionMessage("17 5 2 - -", expressionId));
        Assert.assertEquals(calculator.result(), new Float(14));
    }
    @Test
    public void should_evaluate_simple_multiplication() {
        bus.publish(new ExpressionMessage("5 5 *", expressionId));
        Assert.assertEquals(calculator.result(), new Float(25));
    }

    @Test
    public void should_evaluate_more_complex_multiplication() {
        bus.publish(new ExpressionMessage("5 5 5 * *", expressionId));
        Assert.assertEquals(calculator.result(), new Float(125));
    }

    @Test
    public void should_evaluate_simple_division() {

        bus.publish(new ExpressionMessage("10 2 /", expressionId));
        Assert.assertEquals(calculator.result(), new Float(5));
    }

    @Test
    public void should_evaluate_more_complex_division() {
        bus.publish(new ExpressionMessage("2 9 3 /", expressionId));
        Assert.assertEquals(calculator.result(), new Float(3));
    }

    @Test
    public void should_evaluate_simple_floating_number() {
        bus.publish(new ExpressionMessage("2.5 2.5 +", expressionId));
        Assert.assertEquals(calculator.result(), new Float(5));
    }

    @Test
    public void should_evaluate_more_complex_floating_number() {
        bus.publish(new ExpressionMessage("2.5 2 +", expressionId));
        Assert.assertEquals(calculator.result(), new Float(4.5));
    }

    @Test
    public void should_evaluate_more_complex_floating_number_2() {

        bus.publish(new ExpressionMessage("2.5 2.5 *", expressionId));
        Assert.assertEquals(calculator.result(), new Float(6.25));
    }

    @Test public void should_evaluate_very_complex_calcul() {

        bus.publish(new ExpressionMessage("3 5 8 * 7 + *", expressionId));
        Assert.assertEquals(calculator.result(), new Float(141));
    }

    @Test public void should_evaluate_strange_complex_calcul() {

        bus.publish(new ExpressionMessage("15 7 1 1 + - / 3 * 2 1 1 + + -", expressionId));
        Assert.assertEquals(calculator.result(), new Float(5));
    }

}
