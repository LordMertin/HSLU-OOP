package ch.hslu.oop.SW02;

public final class DatatypeMath {
    
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        int intOverflow = Integer.MAX_VALUE + 1;
        float floatOverflow = Float.MAX_VALUE + 1f;

        System.out.println("Maximaler Integer-Wert + 1: " + Integer.MAX_VALUE + " + 1 = " + intOverflow);
        System.out.println("Maximaler Float-Wert + 1: " + Float.MAX_VALUE + " + 1 = " + floatOverflow);

        float mathFloat = 2f + 5f / 2f;
        System.out.println(mathFloat); // = 4.5
        int mathInt = 2 + 5 / 2;
        System.out.println(mathInt); // = 4 -> 5 / 2 = 2.5 - the .5 gets cut off
        
        System.out.println(2 + 5f / 2); // the 5 needs to be a float so it can keep its 0.5 value
    }
    
}
