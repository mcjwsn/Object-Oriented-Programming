package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int updatesCounter = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        synchronized (System.out) {
            System.out.println("Update #" + (++updatesCounter) + ": " + message + " on Map with ID: " + worldMap.getId());
            System.out.println(worldMap);
        }
    }
}