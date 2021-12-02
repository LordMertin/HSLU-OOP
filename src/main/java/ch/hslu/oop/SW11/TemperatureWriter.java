package ch.hslu.oop.SW11;

import ch.hslu.oop.SW10.TemperatureHistoryExercise.MyLogger;
import ch.hslu.oop.SW10.TemperatureHistoryExercise.Temperature;
import ch.hslu.oop.SW10.TemperatureHistoryExercise.TemperatureHistory;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class TemperatureWriter {
    private static final Logger LOG = Logger.getLogger(MyLogger.class.toString());


    public static void main(String[] args) {
        String input;
        TemperatureHistory temperatureHistory = new TemperatureHistory();

        Scanner scanner = new Scanner(System.in);
        do {
            LOG.info("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            float value;
            try {
                value = Float.parseFloat(input);
                LOG.info("Eingegebene Temparatur: " + input);
                temperatureHistory.add(Temperature.createFromCelsius(value));
                temperatureHistory.addPropertyChangeListener(e -> {});


            } catch (NumberFormatException e) {
                LOG.warning(e.getMessage());
            } catch (IllegalArgumentException e) {
                LOG.severe(e.getMessage());
            }
        } while (!input.equals("exit"));

        //filestuff
        LOG.info("writing temperatures into file");
        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("src\\main\\java\\ch\\hslu\\oop\\SW11\\Temperatur.txt"))) {

            dataOutputStream.writeInt(temperatureHistory.getCount());

            for (int i = 0; i < temperatureHistory.getCount(); i++){
                Temperature temperature = temperatureHistory.get(i);
                dataOutputStream.writeFloat(temperature.getCelsius());
            }

        } catch (IOException ioe){
            LOG.warning("Datei konnte nicht geschrieben werden." + ioe);
        }

        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src\\main\\java\\ch\\hslu\\oop\\SW11\\Temperatur.txt"))) {

            final int count = dataInputStream.readInt();
            LOG.info("Anzahl Temperaturwerte: " + count);

            for (int i = 0; i < count; i++){
                final float temp = dataInputStream.readFloat();
                LOG.info("Temperatur Werte: " + temp);
            }

        } catch (IOException ioe){
            LOG.warning("Datei konnte nicht gelesen werden" + ioe);
        }

        LOG.info(temperatureHistory.toString());
        LOG.info("Programm beendet.");
    }
}
