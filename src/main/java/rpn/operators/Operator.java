package rpn.operators;

import rpn.consumer.Consumer;

public interface Operator extends Consumer {
    float calc(float operande1, float operande2);
}
