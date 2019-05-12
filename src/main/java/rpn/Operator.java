package rpn;

abstract class Operator {
    Operator() { }

    abstract Operande calc(Operande operande1, Operande operande2);
}

class Addition extends Operator {
    Addition() { }

    @Override
    Operande calc(Operande operande1, Operande operande2) {
        Float result = operande1.getResult() + operande2.getResult();
        return new Operande(result);
    }
}

class Soustraction extends Operator {

    Soustraction() { }

    @Override
    Operande calc(Operande operande1, Operande operande2) {
        return new Operande(operande2.getResult() - operande1.getResult());
    }
}

class Division extends Operator {
    Division() { }

    @Override
    Operande calc(Operande operande1, Operande operande2) {
        if(operande1.getResult() == 0 || operande2.getResult() == 0){
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        return new Operande(operande2.getResult() / operande1.getResult());
    }
}

class Multiplication extends Operator {
    Multiplication() { }

    @Override
    Operande calc(Operande operande1, Operande operande2) {
        return new Operande(operande1.getResult() * operande2.getResult());
    }
}