package ch.hslu.oop.SW07;

import java.util.Objects;

public class Point {
    private int x, y;

    public Point(int newX, int newY) {
        x = newX;
        y = newY;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return x == point.x && y == point.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Point punkt1 = new Point(1,5);
        int quadrant = punkt1.getQuadrant(punkt1.x, punkt1.y);
		System.out.print("Quadrant: " + quadrant);
    }
}
