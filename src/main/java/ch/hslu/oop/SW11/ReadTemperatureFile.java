package ch.hslu.oop.SW11;

import ch.hslu.oop.SW10.TemperatureHistoryExercise.MyLogger;
import ch.hslu.oop.SW10.TemperatureHistoryExercise.Temperature;
import ch.hslu.oop.SW10.TemperatureHistoryExercise.TemperatureHistory;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ReadTemperatureFile {
    //src\main\java\ch\hslu\oop\SW11
    private static final Logger LOG = Logger.getLogger(MyLogger.class.toString());
    ArrayList<Temperature> temperatureArrayList;

    public Float getFloat(final String input) {
        try {
            return Float.parseFloat(input);
        } catch (NumberFormatException e) {
            LOG.warning("String: {} is not parsable to Float." + input);
            throw e;
        }
    }

    public LocalDateTime getDataTime(final String input) {
        try {
            String newInput = input.replace('"', ' ').trim();
            return LocalDateTime.parse(newInput,
                    DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        } catch (DateTimeParseException e) {
            LOG.warning("String: {} is not parsable to LocalDateTime" + input);
            throw e;
        }
    }

    public String getStringSegment(String[] splitstring, int segment) {
        try {
            return splitstring[segment];
        } catch (NullPointerException e) {
            LOG.warning("Segment {} not found!" + segment);
            throw e;
        }
    }
    public void readFile(final String file) {
        File f = new File(file);
        if(f.exists()){
            try(final BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                TemperatureHistory temperatureHistory = new TemperatureHistory();
                int lines = 0;
                float maxtemp = 0;
                float maxhumidity = 0;
                LocalDateTime maxTempDateTime = LocalDateTime.MIN;
                while ((line = br.readLine()) != null) {
                    lines++;
                    String splitstring[] = line.split(";");

                    String id;
                    LocalDateTime timestamp;
                    float temparature;

                    try {
                        id = getStringSegment(splitstring, 0);
                        timestamp = getDataTime(getStringSegment(splitstring, 1));
                        temparature = getFloat(getStringSegment(splitstring, 2));

                    } catch (Exception e) {
                        LOG.warning("Line caused error! Ignored!" + lines);
                        continue;
                    }

                    if (temparature > maxtemp){
                        maxTempDateTime = timestamp;
                    }
                    temperatureHistory.add(Temperature.createFromCelsius(temparature));
                }
                LOG.info(temperatureHistory.toString());
                LOG.info("Highest temperature Date: " + maxTempDateTime.toString());
            } catch (FileNotFoundException e) {
                LOG.warning("File not found");
            } catch (IOException e) {
                LOG.warning("IOException");
            }
        }

    }

    public static void main(String args[]) {
        LOG.info("Program started.");
        ReadTemperatureFile readTemperatureFile = new ReadTemperatureFile();
        readTemperatureFile.readFile("src\\main\\java\\ch\\hslu\\oop\\SW11\\weatherExport.csv");
    }

}
