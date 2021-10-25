package ch.hslu.oop.SW04;

public class Line{
    private int x1, y1, x2, y2;
    private Point startpoint, endpoint;
    public Line(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        startpoint = new Point(x1, y1);
        endpoint = new Point(x2, y2);
    }
    public Line(Point startPoint, Point endPoint){
        startpoint = startPoint;
        endpoint = endPoint;
    }
    public Point getStartPoint() {
        return this.startpoint;
    }

    public Point getEndPoint() {
        return this.endpoint;
    }

    public void setStartPoint(Point startPoint){
        this.startpoint = startPoint;
    }

    public void setEndPoint(Point endPoint){
        this.endpoint = endPoint;
    }

    public void setStartPoint(int x, int y){
        this.x1 = x;
        this.y1 = y;
    }

    public void setEndPoint(int x, int y){
        this.x2 = x;
        this.y2 = y;
    }


    public static void main(String[] args) {
        Point startPoint = new Point(1,2);
        Point endPoint = new Point(3,4);
        Line line1 = new Line(startPoint, endPoint);
        Point newStartPoint = new Point(5, 6);
        line1.setStartPoint(newStartPoint);
        line1.startpoint.setX(7);

        Line line2 = new Line(11,12,13,14);
        line2.setStartPoint(15,16);
    }
}
