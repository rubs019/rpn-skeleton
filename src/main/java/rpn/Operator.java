package rpn;

abstract class Operator {
    Operator() { }

    abstract Float calc(Float operande1, Float operande2);
}

class Addition extends Operator {
    Addition() { }

    @Override
    Float calc(Float operande1, Float operande2) {
        Float result = operande1 + operande2;
        return new Float(result);
    }
}

class Soustraction extends Operator {

    Soustraction() { }

    @Override
    Float calc(Float operande1, Float operande2) {
        return new Float(operande2 - operande1);
    }
}

class Division extends Operator {
    Division() { }

    @Override
    Float calc(Float operande1, Float operande2) {
        if(operande1 == 0 || operande2 == 0){
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        return new Float(operande2 / operande1);
    }
}

class Multiplication extends Operator {
    Multiplication() { }

    @Override
    Float calc(Float operande1, Float operande2) {
        return new Float(operande1 * operande2);
    }
}