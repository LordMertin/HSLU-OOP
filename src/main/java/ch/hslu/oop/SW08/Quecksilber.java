package ch.hslu.oop.SW08;

public class Quecksilber extends Element {

    public Quecksilber(){
        super("Hg", -39f, 357f);
    }

    @Override
    public String toString(){
        return super.toString() + ", GIFTIG!";
    }

    public static void main(String[] args) {
        Quecksilber quecksilber = new Quecksilber();
        System.out.println(quecksilber.toString());
        quecksilber.getAggregateState(20);
    }
}
