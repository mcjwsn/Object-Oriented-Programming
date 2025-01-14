package agh.ics.oop;
import agh.ics.oop.model.*;
import agh.ics.oop.model.util.*;
import javafx.application.Platform;
import agh.ics.oop.presenter.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation implements Runnable {
    private final  List<Animal> animals;
    private final List<MoveDirection> directions;
    private final WorldMap map;
    private MapChangeListener listener;

    public Simulation(List<MoveDirection> directions,List<Vector2d> positions, WorldMap map) {
        this.animals = new ArrayList<>();
        for (Vector2d position : positions) {
            try {
                Animal animal = new Animal(MapDirection.NORTH, position);
                map.place(animal);
                this.animals.add(animal);
            } catch (IncorrectPositionException e) {
                //System.out.println("Warning: " + e.getMessage());
                e.printStackTrace();
            }
        }
        this.directions = directions;
        this.map = map;
    }
    public void run() {
        try {
            Thread.sleep(1700); // pierwsza inicjalizacja potrzebuje mniej/wiecej tyle czasu zeby lapac wszystko
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < directions.size(); i++) {
            Animal animal = animals.get(i % animals.size());
            Vector2d oldPosition = animal.getPosition(); // Pozycjaprzed ruchem

            map.move(animal, directions.get(i)); // Ruch zwierzeca
            Vector2d newPosition = animal.getPosition(); // Pozycja po ruchu

            Platform.runLater(() -> {
                if (listener != null) {
                    listener.mapChanged(map, "Animal moved to new position");

                    //dodanie informacji o zmianie pozycji
                   // String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                   // System.out.printf("%s Animal was moved from position %s to position %s.%n",
                           // timestamp, oldPosition, newPosition);
                }
            });

            try {
                Thread.sleep(500); // nie nadaza wizualizacja za algorytmem
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals); // collections.unmodifiableList
    }
}

