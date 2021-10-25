package ch.hslu.oop.SW05;

public abstract class Shape {
    private int x,y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int newX, int newY){
        x = newX;
        y = newY;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public abstract int getPerimeter();

    public abstract int getArea();
}
