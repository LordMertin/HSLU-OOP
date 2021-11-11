package ch.hslu.oop.SW07;

import java.util.Objects;

public class Temperature {
    private float currentTemperatureInC = 20.0f;

    
    /** 
     * @param newTempinC
     */
    public void setTempInC(float newTempinC){
        currentTemperatureInC = newTempinC;
    }
    
    /** 
     * @param newTempinK
     */
    public void setTempInK(float newTempinK){
        currentTemperatureInC = newTempinK - 273.15f;
    }
    
    /** 
     * @param newTempinF
     */
    public void setTempInF(float newTempinF){
        currentTemperatureInC = (newTempinF - 32f) * 1.8f ;
    }
    
    /** 
     * @return float
     */
    public float getTempInC(){
        return currentTemperatureInC;
    }
    
    /** 
     * @return float
     */
    public float getTempInK(){
        return currentTemperatureInC + 273.15f;
    }
    
    /** 
     * @return float
     */
    public float getTempInF(){
        return currentTemperatureInC * 1.8f + 32f;
    }
    
    /** 
     * @return String
     */
    /*
    public TemperatureSW02(float initTemp) {
        currentTemperatureInC = initTemp;
    }
    */
    public String setChemicalElement(String element){
        String aggregatzustand = "no value";
        switch (element){
            case "N": //stickstoff Schmelzpunkt	(−210,01 °C) Siedepunkt	(−195,80 °C)
                if(currentTemperatureInC >= -195.80f){
                    aggregatzustand = "gasförmig";
                } 
                else if(currentTemperatureInC >= -210.01f){
                    aggregatzustand = "flüssig";
                }
                else{
                    aggregatzustand = "fest";
                }
                break;
            case "Hg": //quecksilber Schmelzpunkt (−38,83 °C) Siedepunkt	(356,73 °C)
                if(currentTemperatureInC >= 356.73f){
                    aggregatzustand = "gasförmig";
                } 
                else if(currentTemperatureInC >= -38.83f){
                    aggregatzustand = "flüssig";
                }
                else{
                    aggregatzustand = "fest";
                }
                break;
            case "Pb": //Blei Schmelzpunkt	(327,43 °C) Siedepunkt	(1750 °C)
                if(currentTemperatureInC >= 1750f){
                    aggregatzustand = "gasförmig";
                } 
                else if(currentTemperatureInC >= 327.43f){
                    aggregatzustand = "flüssig";
                }
                else{
                    aggregatzustand = "fest";
                    
                }
                break;
            default:
                aggregatzustand = "Could'nt detect any element from the list. Error";
                break;
        }
        return aggregatzustand;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof final Temperature temperature)){
            return false;
        }

        return Float.compare(temperature.currentTemperatureInC, this.currentTemperatureInC) == 0;
    }


    @Override
    public int hashCode() {
        return Objects.hash(currentTemperatureInC);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Temperature temperature = new Temperature();
        System.out.println(temperature.getTempInC());
        
        System.out.println("Set Temp to 10 °C");
        temperature.setTempInC(10f);

        System.out.println("Celsius: " + temperature.getTempInC());
        System.out.println("Kelvin: " + temperature.getTempInK());
        System.out.println("Fahrenheit: " + temperature.getTempInF());

        temperature.setTempInC(50f);
        System.out.println("N: " + temperature.setChemicalElement("N"));
        System.out.println("Hg: " + temperature.setChemicalElement("Hg"));
        System.out.println("Pb: " + temperature.setChemicalElement("Pb"));

        System.out.println("H2O: " + temperature.setChemicalElement("H2O"));
    }
}