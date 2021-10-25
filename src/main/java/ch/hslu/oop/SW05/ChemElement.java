package ch.hslu.oop.SW05;

public class ChemElement{
    private String elementName;
    private float meltingPoint;
    private float boilingPoint;

    //constructor
    public ChemElement(String newElementName, float newMeltingPoint, float newBoilingPoint) {
        elementName = newElementName;
        meltingPoint = newMeltingPoint;
        boilingPoint = newBoilingPoint;
    }

    
    /** 
     * @return String
     */
    public String getElementName(){
        return elementName;
    }
    
    
    /** 
     * @param celsiusTemp
     * @return String
     */
    public String getAggregate(float celsiusTemp){
        if(celsiusTemp >= boilingPoint){
            return "gasförmig";
        } 
        else if(celsiusTemp >= meltingPoint){
            return "flüssig";
        }
        else{
            return "fest";
        }
    }
}