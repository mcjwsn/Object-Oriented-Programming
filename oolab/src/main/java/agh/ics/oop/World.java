package agh.ics.oop;
import agh.ics.oop.model.*;
import agh.ics.oop.model.util.RandomPointsGenerator;

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
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        WorldMap map = new GrassField(100);
        Simulation simulation = new Simulation(directions,positions,map);
        simulation.run();

        //RandomPointsGenerator generator = new RandomPointsGenerator(4, 4, 3);
        //for(Vector2d position:generator) {
        //System.out.println(position); // dziala}
        // visualizer pokazuje od 9 w gore liczby obok siebie, nie oddzielne spacja, nie chce w nim teraz grzebac bo go pewnie zepsuje
}
}