package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.CLI.evaluate;

public class CLITest {

    @Test
    public void should_evaluate_single_digit_constant() {
        assertThat(evaluate("5")).isEqualTo(5);
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        assertThat(evaluate("17")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_simple_addition() {
        assertThat(evaluate("17 5 +")).isEqualTo(22);
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        assertThat(evaluate("2 3 5 + +")).isEqualTo(10);
    }

    @Test
    public void should_evaluate_simple_substraction() {
        assertThat(evaluate("2 1 -")).isEqualTo(1);
    }

    @Test
    public void should_evaluate_more_complex_substraction() {
        assertThat(evaluate("17 5 2 - -")).isEqualTo(14);
    }

    @Test
    public void should_evaluate_simple_multiplication() {
        assertThat(evaluate("5 5 *")).isEqualTo(25);
    }

    @Test
    public void should_evaluate_more_complex_multiplication() {
        assertThat(evaluate("5 5 5 * *")).isEqualTo(125);
    }

    @Test
    public void should_evaluate_simple_division() {
        assertThat(evaluate("10 2 /")).isEqualTo(5);
    }

    @Test
    public void should_evaluate_more_complex_division() {
        assertThat(evaluate("2 9 3 /")).isEqualTo(3);
    }

    @Test
    public void should_evaluate_simple_floating_number() {
        assertThat(evaluate("2.5 2.5 +")).isEqualTo(5);
    }

    @Test
    public void should_evaluate_more_complex_floating_number() {
        assertThat(evaluate("2.5 2 +")).isEqualTo(4.5f);
    }

    @Test
    public void should_evaluate_more_complex_floating_number_2() {
        assertThat(evaluate("2.5 2.5 *")).isEqualTo(6.25f);
    }

    @Test public void should_evaluate_very_complex_calcul() {
        assertThat(evaluate("3 5 8 * 7 + *")).isEqualTo(141);
    }

    @Test public void should_evaluate_strange_complex_calcul() {
        assertThat(evaluate("15 7 1 1 + - / 3 * 2 1 1 + + -")).isEqualTo(5);
    }
}