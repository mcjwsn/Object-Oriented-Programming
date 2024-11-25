package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.List;

public class World {
    public static void run(MoveDirection[] args){
        for(MoveDirection arg : args) {
            String output = switch (arg) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tylu";
                case RIGHT -> "Zwierzak idzie w prawo";
                case LEFT -> "Zwierzak idzie w lewo";
            };
            System.out.println(output);
        }
    }
    public static void main(String[] args) {
        try {
            List<MoveDirection> directions = OptionsParser.parse(args);
            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
            AbstractWorldMap map = new GrassField(10);
            // AbstractWorldMap map = new RectangularMap(5, 5);
            map.addObserver(new ConsoleMapDisplay());
            Simulation simulation = new Simulation(directions, positions, map);
            simulation.run();
        } catch (IllegalArgumentException e) {
           // System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
}
}