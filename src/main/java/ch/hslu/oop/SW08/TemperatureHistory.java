package ch.hslu.oop.SW08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TemperatureHistory {
    private final Collection<Temperature> temperatures;

    public TemperatureHistory(){
        temperatures = new ArrayList<Temperature>();
    }
    public void add(Temperature temperature){
        temperatures.add(temperature);
    }
    public void clear(){
        temperatures.clear();
    }
    public int getCount(){
        return temperatures.size();
    }
    public float getHighest(){
        if (this.getCount() > 0) {
            return Collections.max(temperatures).getCelsius();
        }
        return -Float.MAX_VALUE;
    }
    public float getLowest(){
        if (this.getCount() > 0) {
            return Collections.min(temperatures).getCelsius();
        }
        return Float.MAX_VALUE;
    }
    public float getAverage(){
        if (this.getCount() > 0) {
            float all = 0f;
            for (final Temperature temparature : temperatures) {
                all += temparature.getCelsius();
            }
            return all / this.getCount();
        }
        return 0f;
    }

}
