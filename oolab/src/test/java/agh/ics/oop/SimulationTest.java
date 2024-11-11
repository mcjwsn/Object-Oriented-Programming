package agh.ics.oop;

import org.junit.jupiter.api.Test;
import agh.ics.oop.model.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class SimulationTest {
    @Test
    public void testAnimalOrientationNorth() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "r", "b","l"});
        RectangularMap map = new RectangularMap(5,5);
        Simulation simulation = new Simulation(directions, positions,map);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    public void testAnimalOrientationSouth() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "l", "b","l"});
        RectangularMap map = new RectangularMap(5,5);
        Simulation simulation = new Simulation(directions, positions,map);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(MapDirection.SOUTH, animal.getOrientation());
    }

    @Test
    public void testAnimalOrientationWest() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "l", "b","f"});
        RectangularMap map = new RectangularMap(5,5);
        Simulation simulation = new Simulation(directions, positions,map);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(MapDirection.WEST, animal.getOrientation());
    }

    @Test
    public void testAnimalOrientationEast() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"r","f", "r", "b", "r", "r","f", "r"});
        RectangularMap map = new RectangularMap(5,5);
        Simulation simulation = new Simulation(directions, positions,map);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(MapDirection.EAST, animal.getOrientation());
    }

    @Test
    public void testAnimalPositionAfterMoveToNorth() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f"});
        RectangularMap map = new RectangularMap(5,5);
        Simulation simulation = new Simulation(directions, positions,map);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(2,3), animal.getPosition());
    }

    @Test
    public void testAnimalPositionAfterMoveToSouth() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"r","r","f"});
        RectangularMap map = new RectangularMap(5,5);
        Simulation simulation = new Simulation(directions, positions,map);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(2,1), animal.getPosition());
    }

    @Test
    public void testAnimalPositionAfterMoveToEast() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"r","f"});
        RectangularMap map = new RectangularMap(5,5);
        Simulation simulation = new Simulation(directions, positions,map);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(3,2), animal.getPosition());
    }

    @Test
    public void testAnimalPositionAfterMoveToWest() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"l","f"});
        RectangularMap map = new RectangularMap(5,5);
        Simulation simulation = new Simulation(directions, positions,map);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(1,2), animal.getPosition());
    }

    @Test
    public void testDidAnimalLeftTheMapToNorth() {
        List<Vector2d> positions = List.of(new Vector2d(4, 4));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f"});
        RectangularMap map = new RectangularMap(5,5);
        Simulation simulation = new Simulation(directions, positions,map);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(4,4), animal.getPosition());
    }

    @Test
    public void testDidAnimalLeftTheMapToSouth() {
        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"l","l","f"});
        RectangularMap map = new RectangularMap(5,5);
        Simulation simulation = new Simulation(directions, positions,map);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(0,0), animal.getPosition());
    }

    @Test
    public void testDidAnimalLeftTheMapToEast() {
        List<Vector2d> positions = List.of(new Vector2d(5, 5));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"r","f"});
        RectangularMap map = new RectangularMap(6,6);
        Simulation simulation = new Simulation(directions, positions,map);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(5,5), animal.getPosition());
    }

    @Test
    public void testDidAnimalLeftTheMapToWest() {
        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"l","f"});
        RectangularMap map = new RectangularMap(5,5);
        Simulation simulation = new Simulation(directions, positions,map);
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertEquals(new Vector2d(0,0), animal.getPosition());
    }

    @Test
    public void AreTheAnimalsMoving()
    {
        List <Vector2d> positions = List.of(new Vector2d(0, 0), new Vector2d(1, 0), new Vector2d(2, 0), new Vector2d(3,0), new Vector2d(4,0));
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f"});
        RectangularMap map = new RectangularMap(5,5);
        Simulation simulation = new Simulation(directions, positions,map);
        simulation.run();
        for (int YthPosition=0;YthPosition<5;YthPosition++)
        {
            Vector2d currentCheckingPosition = new Vector2d(YthPosition,4);
            assertTrue(map.isOccupied(currentCheckingPosition));
        }
    }

    @Test
    public void AnimalsRunningWithCorrectDirections() {
        List<MoveDirection> directions = new ArrayList<>();
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.LEFT);
        directions.add(MoveDirection.BACKWARD);

        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(0, 1));
        RectangularMap map = new RectangularMap(10,11);

        Simulation simulation = new Simulation(directions, positions, map);
        simulation.run();

        List<Animal> animals = simulation.getAnimals();

        assertEquals(1, animals.size());

        Animal animal = animals.get(0);
        assertTrue(animal.getOrientation() == MapDirection.WEST);
        assertFalse(animal.getPosition().equals(new Vector2d(0, 0)));
    }

    @Test
    public void AnimalsRunningWithIncorrectDirections() {
        List<MoveDirection> directions = new ArrayList<>();
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.BACKWARD);

        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(0, 0));
        RectangularMap map = new RectangularMap(5,5);

        Simulation simulation = new Simulation(directions, positions, map);
        simulation.run();

        List<Animal> animals = simulation.getAnimals();

        assertEquals(1, animals.size());

        Animal animal = animals.get(0);
        assertTrue(animal.getOrientation() == MapDirection.EAST);
        assertTrue(animal.getPosition().equals(new Vector2d(0, 1)));
    }

    @Test
    public void TwoAnimalsCrossing(){
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"b","l","f","f","f","f","f","f","f"});

        List<Vector2d> positions = List.of(new Vector2d(1,0), new Vector2d(2,1));

        RectangularMap map = new RectangularMap(3,3);

        Simulation simulation = new Simulation(directions, positions, map);
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertEquals(2, animals.size());

        Animal animal1 = animals.get(0);
        assertEquals(animal1.getPosition(),new Vector2d(1, 2));
        assertTrue(animal1.getOrientation().equals(MapDirection.NORTH));

        Animal animal2 = animals.get(1);
        assertEquals(animal2.getPosition(),new Vector2d(0, 1));
        assertTrue(animal2.getOrientation().equals(MapDirection.WEST));
    }

    @Test
    public void StartingWithTwoAnimalsButEndingWithOne(){
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f","b","r","l","f","f","r","r","f","f","f","f"});

        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(2,2));

        RectangularMap map = new RectangularMap(5,5);

        Simulation simulation = new Simulation(directions, positions, map);
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertEquals(1, animals.size());

        Animal animal1 = animals.get(0);
        assertTrue(animal1.getPosition().follows(new Vector2d(0, 0)));
        assertTrue(animal1.getPosition().precedes(new Vector2d(4, 4)));
        assertEquals(animal1.getOrientation(), MapDirection.SOUTH);
        assertEquals(animal1.getPosition(),new Vector2d(2, 0));
    }

}