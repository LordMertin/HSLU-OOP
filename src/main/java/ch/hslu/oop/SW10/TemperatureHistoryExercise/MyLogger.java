package ch.hslu.oop.SW10.TemperatureHistoryExercise;

import java.util.Scanner;
import java.util.logging.Logger;

public class MyLogger {
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
        LOG.info(temperatureHistory.toString());
        LOG.info("Programm beendet.");
    }
}
