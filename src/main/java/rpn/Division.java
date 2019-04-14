package rpn;

public class Division extends Symbol{
    @Override
    Long calc(Object stack, Object stack1) {
        Long operande1 = Long.parseLong(stack.toString());
        Long operande2 = Long.parseLong(stack1.toString());

        return operande2 / operande1;
    }
}
