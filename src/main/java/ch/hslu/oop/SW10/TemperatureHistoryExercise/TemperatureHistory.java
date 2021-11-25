package ch.hslu.oop.SW10.TemperatureHistoryExercise;

import ch.hslu.oop.SW09.MyLogger;
import ch.hslu.oop.SW10.CarExercise.Status;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class TemperatureHistory {
    private final Collection<Temperature> temperatures;
    private final List<PropertyChangeListener> changeListener = new ArrayList<PropertyChangeListener>();
    private static final Logger LOG = Logger.getLogger(MyLogger.class.toString());

    public TemperatureHistory(){
        temperatures = new ArrayList<Temperature>();
    }
    public void add(Temperature temperature){
        float max = this.getHighest();
        float min = this.getLowest();
        if(Float.compare(max, temperature.getCelsius()) == -1){
            //fire event- a new max temp is here
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "temperatures", max, temperature.getCelsius());
            this.firePropertyChangeEvent(pcEvent);
            LOG.info("a new highest temperature got added");
        }
        if(Float.compare(min, temperature.getCelsius()) == 1){
            //fire event- a new min temp is here
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "temperatures", min, temperature.getCelsius());
            this.firePropertyChangeEvent(pcEvent);
            LOG.info("a new lowest temperature got added");
        }
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

    @Override
    public String toString(){
        return "TemperatureHistory{ Count: " + this.getCount() + ", " +
                "Average: " + this.getAverage() + ", " +
                "Highest temperature: " + this.getHighest() + ", " +
                "Lowest Temperature: " + this.getLowest() + " }";
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        if(listener != null) {
            this.changeListener.add(listener);
        } else {
            LOG.info("Listener was null");
        }
    }

    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null) {
            this.changeListener.remove(listener);
        } else {
            LOG.info("Listener was null");
        }
    }

    private void firePropertyChangeEvent(PropertyChangeEvent pcEvent) {
        for (final PropertyChangeListener listener : this.changeListener) {
            listener.propertyChange(pcEvent);
        }
    }

}
