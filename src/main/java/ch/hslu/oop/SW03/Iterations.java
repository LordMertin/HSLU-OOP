package ch.hslu.oop.SW03;

public class Iterations {
    //constructor
    public Iterations() {
        
    }
    //best
    public void forZeroToTen(){
        for(int i = 0; i<=10; i++){
            System.out.println(i);
        }
    }
    //second best
    public void whileZeroToTen(){
        int i = 0;
        while(i <= 10){
            System.out.println(i);
            i++;
        }
    }
    //worst and cringe
    public void dowhileZeroToTen(){
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);
    }

    public void floatUntilOne(){
        float f = 0.9f;
        int i = 0;
        while(f <= 1f){
            f += 0.000025f;
            System.out.println(f);
            i++;
        }
        System.out.println("fertig! es hat: " + i + " iterationen gebraucht! WOW Überraschend nicht??!!!?!?!?!?!?!");
    }

    public void floatUntilOneFor(){
        float f = 0.9f;
        for(int i = 0; i <= 4000; i++){
            f += 0.000025f;
            System.out.println("float wert: " + f + "\nIterationNr: " + i);
            i++;
        }
    }

    
    /** 
     * @param height
     * @param width
     */
    public void printBox(final int height, final int width){
        for(int h = 1; h <= height; h++){
            for(int w = 1; w <= width; w++){
                if(h == 1 || h == height){
                    System.out.print("#");
                }
                else if(w == 1 || w == width){
                    System.out.print("#");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
    
    /** 
     * @param size
     * @param c
     */
    public void printSwissCrossChar(int size, String c){
    String color;
    String colorReset = "\u001B[0m";
    if(c == "#"){
        color = "\u001B[0m";
    }else{
        color = "\u001B[31m";
    }
        for(int x = 1; x <= size; x++){
            System.out.print(color + c + colorReset);
        }

    }
    

    
    /** 
     * @param size
     */
    public void swissCross(final int size){
        int i = 0;
        printSwissCrossChar(size*3+4, "@");
        System.out.println("");
        while(i < size/2){
            System.out.print("\u001B[31m" + "@@");
            printSwissCrossChar(size, "@");
            printSwissCrossChar(size, "#");
            printSwissCrossChar(size, "@");
            System.out.print("\u001B[31m" + "@@");
            System.out.println("");
            i++;
        }
        while(i < size/2 * 2){
            System.out.print("\u001B[31m" + "@@");
            printSwissCrossChar(size*3, "#");
            System.out.print("\u001B[31m" + "@@");
            System.out.println("");
            i++;
        }
        while(i < size/2*3){
            System.out.print("\u001B[31m" + "@@");
            printSwissCrossChar(size, "@");
            printSwissCrossChar(size, "#");
            printSwissCrossChar(size, "@");
            System.out.print("\u001B[31m" + "@@");
            System.out.println("");
            i++;
        }
        printSwissCrossChar(size*3+4, "@");
        System.out.println("");
        
        
    }
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Iterations iteration = new Iterations();
        //iteration.forZeroToTen();
        //iteration.dowhileZeroToTen();
        //iteration.whileZeroToTen();
        //iteration.floatUntilOne();
        //iteration.floatUntilOneFor();
        //iteration.printBox(4, 10);
        iteration.swissCross(12); //max 30 because terminal is too small
    }
    
}