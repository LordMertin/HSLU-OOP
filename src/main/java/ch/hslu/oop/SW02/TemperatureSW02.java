package ch.hslu.oop.SW02;

public class TemperatureSW02 {
    private float currentTemperatureinC;

    
    /** 
     * @param newTempinC
     */
    public void setTempInC(float newTempinC){
        currentTemperatureinC = newTempinC;
    }
    
    /** 
     * @param newTempinK
     */
    public void setTempInK(float newTempinK){
        currentTemperatureinC = newTempinK - 273.15f;
    }
    
    /** 
     * @param newTempinF
     */
    public void setTempInF(float newTempinF){
        currentTemperatureinC = (newTempinF - 32f) * 1.8f ;
    }
    
    /** 
     * @return float
     */
    public float getTempInC(){
        return currentTemperatureinC;
    }
    
    /** 
     * @return float
     */
    public float getTempInK(){
        return currentTemperatureinC + 273.15f;
    }
    
    /** 
     * @return float
     */
    public float getTempInF(){
        return currentTemperatureinC * 1.8f + 32f;
    }
    
    public TemperatureSW02(float initTemp) {
        currentTemperatureinC = initTemp;
    }
    
    public TemperatureSW02(){
        currentTemperatureinC = 20f;
    }
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        TemperatureSW02 temperature = new TemperatureSW02();
        System.out.println(temperature.getTempInC());
        
        System.out.println("Set Temp to 0 °C");
        temperature.setTempInC(0f);

        System.out.println("Celsius: " + temperature.getTempInC());
        System.out.println("Kelvin: " + temperature.getTempInK());
        System.out.println("Fahrenheit: " + temperature.getTempInF());
    }
}