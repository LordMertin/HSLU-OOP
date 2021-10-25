package ch.hslu.oop.SW05;

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
    
}
