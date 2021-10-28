package ch.hslu.oop.SW06;

public class Circle extends Shape {

    private int diameter;

    public Circle(int x, int y, int diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    public void setDiameter(int newDiameter){
        diameter = newDiameter;
    }
    
    public int getDiameter(){
        return diameter;
    }
    
    @Override
    public int getPerimeter() {
        return (int)Math.PI * getDiameter();
    }

    @Override
    public int getArea() {
        return (int)Math.PI * ((getDiameter()^2)/4);
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5, 5, 7);
        Shape shape = (Circle) circle;
        shape.move(1, 2);
        if(shape instanceof Circle){
            ((Circle)shape).getDiameter();
        }



    }
    
}
