package ch.hslu.oop.SW03;

public class minmax{

    
    /** 
     * @param a
     * @param b
     * @param c
     * @return int
     */
    public int max1(int a, int b, int c){
        //a is greater than or equals to b AND c
        if(a >= b && a >= c){ 
            return a;   
        }
        //b is greater than or equals to a AND c
        else if(b >= a && b >= c){ 
            return b;
        }
        //if a and b werent bigger than c means c is the biggest
        else{ 
            return c;
        }
    }
    
    /** 
     * @param a
     * @param b
     * @param c
     * @return int
     */
    public int max2(int a, int b, int c){
        return Math.max(Math.max(a, b), c);
    }
    
    /** 
     * @param numList
     * @return int
     */
    public int max3(int[] numList){
        int maxValue = numList[0];
		for(int i=1;i<numList.length;i++) {
			if (numList[i] > maxValue) {
				maxValue = numList[i];
			}	
		}
		return maxValue;
    }
    
    /** 
     * @param a
     * @param b
     * @return int
     */
    public int min(int a, int b){
        if(a > b){
            return b;
        }
        else{
            return a;
        }
    }
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        minmax minmax = new minmax();
        System.out.println("Smallest number of 7, 3: " + minmax.min(7, 3));
        System.out.println("Highest number of 654, 342, 23 (max1): " + minmax.max1(654, 342, 23));
        System.out.println("Highest number of 543, 432, 756 (max2): " + minmax.max2(543, 432, 756));
        int[] numbers = new int[]{84,35,75,368,3546,35,23,7,3,8,389,10,100,99};
        System.out.println("Highest number of array (max3): " + minmax.max3(numbers));
    }
}