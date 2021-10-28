package ch.hslu.oop.SW06;

public class Point {
    private int x, y;

    public Point(int newX, int newY) {
        setX(newX);
        setY(newY);
    }

    public Point(Point point){
        setX(point.getX());
        setY(point.getY());
    }

    public void setX(int newX){
        x = newX;
    }
    public void setY(int newY){
        y = newY;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    /**
     * @param x
     * @param y
     * @return int
     */
    public int getQuadrant(int x, int y){
        if ((x == 0) || (y == 0)) {
            return 0;
        }
        if (x > 0) {
            if (y > 0) {
                return 1;
            } else {
                return 4;
            }
        } else {
            if (y > 0) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    public void moveRelative(int x, int y){
        setX(getX() + x);
        setY(getY() + y);
    }

    public void moveRelative(Point point){
        moveRelative(point.getX(), point.getY());
    }

    public void moveRelative(double alpha, int amount) {
        this.moveRelative((int)(amount * Math.cos(alpha)), (int)(amount * Math.sin(alpha)));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Point punkt1 = new Point(1,5);
        int quadrant = punkt1.getQuadrant(punkt1.getX(), punkt1.getY());
        System.out.print("Quadrant: " + quadrant);
    }
}
