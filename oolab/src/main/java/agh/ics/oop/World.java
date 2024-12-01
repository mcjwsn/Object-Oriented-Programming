package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.ArrayList;
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
            List<Vector2d> positions2 = List.of(new Vector2d(1,1), new Vector2d(2,3), new Vector2d(5,5));
            AbstractWorldMap map1 = new GrassField(10);
            AbstractWorldMap map2 = new RectangularMap(5, 5);
            AbstractWorldMap map3 = new GrassField(22);
            map1.addObserver(new ConsoleMapDisplay());
            map2.addObserver(new ConsoleMapDisplay());
            map3.addObserver(new ConsoleMapDisplay());
            Simulation simulation1 = new Simulation(directions, positions, map1);
            Simulation simulation2 = new Simulation(directions, positions, map2);
            Simulation simulation3 = new Simulation(directions, positions2, map3);
            SimulationEngine engine = new SimulationEngine(List.of(simulation1, simulation2,simulation3));
            //engine.runAsync();
            /*List<Simulation> simulations = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                AbstractWorldMap map = i % 2 == 0 ? new GrassField(10) : new RectangularMap(5, 5);
                map.addObserver(new ConsoleMapDisplay());
                Simulation simulation = new Simulation(directions, positions, map);
                simulations.add(simulation);
            }
            SimulationEngine newEngine = new SimulationEngine(simulations);
            newEngine.runAsync();*/
            engine.runAsyncInThreadPool();
        } catch (IllegalArgumentException e) {
           // System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("System zakonczyl dzialanie");
}
}