package ch.hslu.oop.SW03;

public class pointSW03 {
    private int x, y;

    public pointSW03(int newX, int newY) {
        x = newX;
        y = newY;
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

    
	/** 
	 * @param args
	 */
	public static void main(String[] args) {
        pointSW03 punkt1 = new pointSW03(1,5);
        int quadrant = punkt1.getQuadrant(punkt1.x, punkt1.y);
		System.out.print("Quadrant: " + quadrant);
    }
}
