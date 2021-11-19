package ch.hslu.oop.SW09;

import java.util.Scanner;
import java.util.logging.Logger;

public class MyLogger {
    private static final Logger LOG = Logger.getLogger(MyLogger.class.toString());

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            LOG.info("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            float value;
            try {
                value = Float.parseFloat(input);
                LOG.info("Eingegebene Temparatur: " + input);
                Temperature.createFromCelsius(value);
            } catch (NumberFormatException e) {
                LOG.warning(e.getMessage());
            } catch (IllegalArgumentException e) {
                LOG.severe(e.getMessage());
            }
        } while (!input.equals("exit"));
        LOG.info("Programm beendet.");
    }
}
