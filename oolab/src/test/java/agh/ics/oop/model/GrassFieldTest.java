package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class GrassFieldTest {
    @Test
    public void testIfMapWorks(){
        WorldMap map = new GrassField(10, List.of(new Vector2d(2,2)));
        Animal animal = new Animal();
        map.place(animal);
        map.move(animal, MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal.getPosition());
    }
    @Test
    public void testCanMoveTo1(){
        WorldMap map = new GrassField(10, List.of(new Vector2d(2,2)));
        Animal animal1 = new Animal();
        map.place(animal1);
        assertTrue(map.canMoveTo(new Vector2d(2, 3)));
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
    }
    @Test
    public void testCanMoveTo2(){
        WorldMap map = new GrassField(10, List.of(new Vector2d(2,2), new Vector2d(2, 3)));
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 3));
        map.place(animal1);
        map.place(animal2);
        assertFalse(map.canMoveTo(new Vector2d(2, 3)));
    }
    @Test
    public void testPlace(){
        WorldMap map = new GrassField(10, List.of(new Vector2d(2,2)));
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 2));
        assertTrue(map.place(animal1));
        assertFalse(map.place(animal2));
    }
    @Test
    public void testMove(){
        WorldMap map = new GrassField(10, List.of(new Vector2d(2,2), new Vector2d(3, 2)));
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(3, 2));
        map.place(animal1);
        map.place(animal2);
        map.move(animal1, MoveDirection.FORWARD);
        map.move(animal2, MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal1.getPosition());
        assertEquals(new Vector2d(3, 1), animal2.getPosition());
    }
    @Test
    public void testIsOccupied(){
        WorldMap map = new GrassField(10, List.of(new Vector2d(2,2)));
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 2));
        map.place(animal1);
        map.place(animal2);
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
    }
    @Test
    public void testObjectAt(){
        WorldMap map = new GrassField(10, List.of(new Vector2d(2,2)));
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(MapDirection.SOUTH, new Vector2d(2, 2));
        map.place(animal1);
        map.place(animal2);
        assertEquals(animal1, map.objectAt(new Vector2d(2, 2)));
        assertEquals(animal1, map.objectAt(new Vector2d(2, 2)));
        assertNull(map.objectAt(new Vector2d(2, 3)));
    }
}