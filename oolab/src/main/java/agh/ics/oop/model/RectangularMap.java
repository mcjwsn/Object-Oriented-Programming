package agh.ics.oop.model;
import agh.ics.oop.model.Vector2d;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {

    private final Map<Vector2d, Animal> animals = new HashMap<>();

    @Override
    public boolean place(Animal animal){
        animals.put(animal.getPosition(), animal);
        Animal foundAnimal = animals.get(new Vector2d(2,1));
        return false;
    }
    @Override
    public void move(Animal animal, MoveDirection direction){}
    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {return false;}
}
