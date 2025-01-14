package agh.ics.oop.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class FileMapDisplay implements MapChangeListener{
    private final String mapID;
    public FileMapDisplay(String mapID) {
        this.mapID = mapID;
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        String filename = mapID + ".log";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println("Move information:");
            writer.println(message);
            writer.println("\nCurrent map state:\n");
            writer.println(worldMap.toString());
            writer.println("-----------------");
        } catch (IOException e) {
            System.err.println("Error while writing to file: " + e.getMessage());
        }
    }
}
