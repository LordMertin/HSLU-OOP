package ch.hslu.oop.SW11;

import ch.hslu.oop.SW09.MyLogger;

import java.io.*;
import java.util.logging.Logger;

public class FileWriter {
    private static final Logger LOG = Logger.getLogger(MyLogger.class.toString());

    public static void writeInt(final String filename, final int input){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream((new FileOutputStream(filename)));
            dos.writeInt(input);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOG.info("Input saved in: " + filename);
    }
    public static void writeString(final String filename, final String input){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream((new FileOutputStream(filename)));
            dos.writeBytes(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOG.info("Input saved in: " + filename);
    }

    public static int readInt(final String file){
        int output = Integer.MAX_VALUE;
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            output = dis.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static void main(String[] args) {
        writeInt("integer.txt", 69);
        writeString("String.txt", "wer string in int umwandeln will ist blöd");
        LOG.info("result: " + readInt("String.txt"));
    }
}
