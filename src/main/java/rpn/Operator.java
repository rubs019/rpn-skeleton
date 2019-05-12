package rpn;

abstract class Operator {
    private Operande operande1;
    private Operande operande2;

    Operator(Operande op1, Operande op2) {
        this.operande1 = op1;
        this.operande2 = op2;
    }

    Operande getOperande1() {
        return operande1;
    }

    Operande getOperande2() {
        return operande2;
    }

    abstract Operande calc();
}

class Addition extends Operator {
    Addition(Operande operande1, Operande operande2) {
        super(operande1, operande2);
    }

    @Override
    Operande calc() {
        Float result = this.getOperande1().getResult() + this.getOperande2().getResult();
        return new Operande(result);
    }
}

class Soustraction extends Operator {
    Soustraction(Operande operande1, Operande operande2) {
        super(operande1, operande2);
    }

    @Override
    Operande calc() {
        return new Operande(this.getOperande2().getResult() - this.getOperande1().getResult());
    }
}

class Division extends Operator {
    Division(Operande operande1, Operande operande2) {
        super(operande1, operande2);
    }

    @Override
    Operande calc() {
        return new Operande(this.getOperande2().getResult() / this.getOperande1().getResult());
    }
}

class Multiplication extends Operator {
    Multiplication(Operande operande1, Operande operande2) {
        super(operande1, operande2);
    }

    @Override
    Operande calc() {
        return new Operande(this.getOperande1().getResult() * this.getOperande2().getResult());
    }
}