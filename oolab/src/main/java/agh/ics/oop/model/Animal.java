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

    public MapDirection getOrientation() {
        return orientation;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }



    public void move (MoveDirection direction, RectangularMap map){
        switch (direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector());
                if (map.canMoveTo(newPosition)){
                    this.position = newPosition;
                };}
            case BACKWARD -> {Vector2d newPosition = this.position.subtract(this.orientation.toUnitVector());
                if(map.canMoveTo(newPosition)){
                    this.position = newPosition;
                };}
            }
    }
}
