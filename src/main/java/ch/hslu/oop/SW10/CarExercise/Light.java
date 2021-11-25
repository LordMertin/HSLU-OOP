package ch.hslu.oop.SW10.CarExercise;

import ch.hslu.oop.SW09.MyLogger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Light implements Switchable {
    private Status status;
    private int lumens;

    private static final Logger LOG = Logger.getLogger(MyLogger.class.toString());
    private final List<PropertyChangeListener> changeListener = new ArrayList<PropertyChangeListener>();
    
    @Override
    public void switchOn(){
        if(isSwitchedOff()){
            this.lumens = 2500;
            status = Status.ON;
            LOG.info("Light is now turned ON. The light has a brightness of " + this.lumens + " lumens.");
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "status", Status.OFF, this.status);
            this.firePropertyChangeEvent(pcEvent);
        }
        else{
            LOG.info("Light is already turned ON");
        }
    }
    @Override
    public void switchOff(){
        if(isSwitchedOn()){
            this.lumens = 0;
            status = Status.OFF;
            LOG.info("Light is now turned OFF");
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "status", Status.ON, this.status);
            this.firePropertyChangeEvent(pcEvent);
        }
        else{
            LOG.info("Light is already turned OFF");
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
