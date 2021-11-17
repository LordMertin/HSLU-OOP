package ch.hslu.oop.SW08;

public enum State {
    SOLID("fest"),
    LIQUID("flüssig"),
    GAS("gasförmig");

    public final String label;

    State(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
