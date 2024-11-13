package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final  List<Animal> animals;
    private final List<MoveDirection> directions;
    private final WorldMap map;

    public Simulation(List<MoveDirection> directions,List<Vector2d> positions, WorldMap map) {
        this.animals = new ArrayList<>();
        for (Vector2d position : positions) {
            Animal animal = new Animal(MapDirection.NORTH, position);
            if(map.place(animal)){
                this.animals.add(animal);
            }
        }
        this.directions = directions;
        this.map = map;
    }
    public void run(){
        System.out.println(map);
            for(int i = 0; i < directions.size(); i++){
                map.move(animals.get(i % animals.size()), directions.get(i));
                System.out.println(map);
        }

    }
    public List<Animal> getAnimals() {
        return List.copyOf(animals); // collections.unmodifiableList
    }
}

