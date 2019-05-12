package rpn;

public class Operande {
    private Float value;

    Operande(Float value) {
        this.value = value;
    }

    private Float getValue() {
        return value;
    }

    public Float getResult() {
        return this.getValue();
    }
}
