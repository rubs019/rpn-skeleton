package rpn;

public class Multiplication extends Symbol{
    @Override
    Long calc(Object stack, Object stack1) {
        Long operande1 = Long.parseLong(stack.toString());
        Long operande2 = Long.parseLong(stack1.toString());

        return operande1 * operande2;
    }
}
