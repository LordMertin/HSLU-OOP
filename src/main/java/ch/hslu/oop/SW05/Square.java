package ch.hslu.oop.SW05;

public class Square extends Rectangle {
    //Kei ahnig ob das so funktioniert lmfao
    public Square(int x, int y, int width) {
        super(x, y, width, width);
    }

    public static void main(String[] args) {
        Square square = new Square(5, 10, 100);
        System.out.println(square.getArea());
    }
}
