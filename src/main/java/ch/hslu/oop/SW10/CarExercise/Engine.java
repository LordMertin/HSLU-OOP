package ch.hslu.oop.SW10.CarExercise;

import ch.hslu.oop.SW09.MyLogger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Engine implements Switchable {
    private Status status;
    private int rpm = 0;

    private static final Logger LOG = Logger.getLogger(MyLogger.class.toString());
    private final List<PropertyChangeListener> changeListener = new ArrayList<PropertyChangeListener>();

    @Override
    public void switchOn(){
        if(isSwitchedOff()){
            this.rpm = 800;
            this.status = Status.ON;
            LOG.info("Engine turned ON. Engine is now idling at " + this.rpm + " rpm");
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "status", Status.OFF, this.status);
            this.firePropertyChangeEvent(pcEvent);
        } 
        else{
            LOG.info("Engine is already ON");
        }
        
    }
    @Override
    public void switchOff(){
        if(isSwitchedOn()){
            this.rpm = 0;
            this.status = Status.OFF;
            LOG.info("Engine turned OFF.");
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "status", Status.ON, this.status);
            this.firePropertyChangeEvent(pcEvent);
        } else {
            LOG.info("Engine is already OFF");
        }
    }
    @Override
    public boolean isSwitchedOff(){
        return !(this.status == Status.ON);
    }
    @Override
    public boolean isSwitchedOn(){
        return (this.status == Status.ON);
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