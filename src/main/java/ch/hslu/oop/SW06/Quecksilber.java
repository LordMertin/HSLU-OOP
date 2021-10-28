package ch.hslu.oop.SW06;

import java.security.PublicKey;

public class Quecksilber extends Element{

    public Quecksilber(){
        super("Hg", -39f, 357f);
    }

    @Override
    public String toString(){
        return super.toString() + ", GIFTIG!";
    }

    public static void main(String[] args) {
        Quecksilber quecksilber = new Quecksilber();
        System.out.print(quecksilber.toString());
    }
}
