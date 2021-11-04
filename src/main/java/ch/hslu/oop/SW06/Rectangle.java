package ch.hslu.oop.SW06;

public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public void changeDimension(int newWidth, int newHeight){
        height = newHeight;
        width = newWidth;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getPerimeter(){
        return (getX() * 2) + (getY() * 2);
    }

    public int getArea(){
        return (getX() * getY());
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 5, 10, 15);
        Shape shape = (Rectangle) rectangle;
        shape.move(1, 2);
        if(shape instanceof Rectangle){
            System.out.println("gringy: " + ((Rectangle)shape).getArea());
        }
    }
}
