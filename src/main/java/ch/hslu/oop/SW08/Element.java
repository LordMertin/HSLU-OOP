package ch.hslu.oop.SW08;

public class Element {

    private String elementName;
    private float meltingPoint, boilingPoint;


    public Element(String elementName, float meltingPoint, float boilingPoint) {
        // initialise instance variables
        this.elementName = elementName;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
    }

    @Override
    public String toString() {
        return "Element Name: " + this.elementName +
                ", Boiling Point: " + this.boilingPoint +
                ", Melting Point: " + this.meltingPoint;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public State getAggregateState(float celsius) {
        if (celsius < this.meltingPoint) {
            System.out.println(this.elementName + " ist bei " + celsius + "°C " + State.SOLID.toString());
            return State.SOLID;
        } else if (celsius < this.boilingPoint) {
            System.out.println(this.elementName + " ist bei " + celsius + "°C " + State.LIQUID.toString());
            return State.LIQUID;
        } else {
            System.out.println(this.elementName + " ist bei " + celsius + "°C " + State.GAS.toString());
            return State.GAS;
        }
    }
}