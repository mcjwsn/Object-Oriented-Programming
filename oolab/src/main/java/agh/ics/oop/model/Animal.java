package agh.ics.oop.model;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MoveDirection;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }
    public Animal(MapDirection orientation, Vector2d position){
        this.orientation = orientation;
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("Animal orientation %s, position %s", orientation, position);
    }

    public Vector2d getPosition() {
        return position;
    }
    // te dwie funckje przydadza sie do testow
    public MapDirection getOrientation() {
        return orientation;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    private final static Vector2d UPPER_MAX = new Vector2d(4,4);
    private final static Vector2d LOWER_MAX = new Vector2d(0,0);


    public void move (MoveDirection direction){
        switch (direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector());
                if (isAbleToMove(newPosition)){
                    this.position = newPosition;
                };}
            case BACKWARD -> {Vector2d newPosition = this.position.subtract(this.orientation.toUnitVector());
                if(isAbleToMove(newPosition)){
                    this.position = newPosition;
                };}
            }
    }

    // czy nie wyjdzie poza mape
    public boolean isAbleToMove(Vector2d position) {
        return position.precedes(UPPER_MAX) && position.follows(LOWER_MAX);
    }
}
