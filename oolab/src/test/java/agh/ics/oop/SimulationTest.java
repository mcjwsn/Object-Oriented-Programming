package agh.ics.oop;

import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class SimulationTest {
    @Test
    public void testAnimalOrientationNorth() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "r", "b","l"});

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    public void testAnimalOrientationSouth() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "l", "b","l"});

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(MapDirection.SOUTH, animal.getOrientation());
    }

    @Test
    public void testAnimalOrientationWest() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "l", "b","f"});

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(MapDirection.WEST, animal.getOrientation());
    }

    @Test
    public void testAnimalOrientationEast() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"r","f", "r", "b", "r", "r","f", "r"});

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(MapDirection.EAST, animal.getOrientation());
    }

    @Test
    public void testAnimalPositionAfterMoveToNorth() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f"});

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(2,3), animal.getPosition());
    }

    @Test
    public void testAnimalPositionAfterMoveToSouth() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"r","r","f"});

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(2,1), animal.getPosition());
    }

    @Test
    public void testAnimalPositionAfterMoveToEast() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"r","f"});

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(3,2), animal.getPosition());
    }

    @Test
    public void testAnimalPositionAfterMoveToWest() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"l","f"});

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(1,2), animal.getPosition());
    }

    @Test
    public void testDidAnimalLeftTheMapToNorth() {
        List<Vector2d> positions = List.of(new Vector2d(4, 4));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f"});

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(4,4), animal.getPosition());
    }

    @Test
    public void testDidAnimalLeftTheMapToSouth() {
        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"l","l","f"});

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(0,0), animal.getPosition());
    }

    @Test
    public void testDidAnimalLeftTheMapToEast() {
        List<Vector2d> positions = List.of(new Vector2d(5, 5));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"r","f"});

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(5,5), animal.getPosition());
    }

    @Test
    public void testDidAnimalLeftTheMapToWest() {
        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"l","f"});

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(0,0), animal.getPosition());
    }
}
// co z przypadkiem, kiedy początkowa pozycja zwierzęcie jest poza mapą? Czy powinno to być jakoś uwzględnione juz teraz?