package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {
    // Tak samo jak w innych nie oplaca sie tutaj robic specjalnie pod given/when/then
    // Przyklado z uzyciem given when then
    //void ChangeDirectionToNextOne()
    //{
    //Given
    // MapDirection north = MapDirection.NORTH;
    //When & Then
    // assertEquals(MapDirection.EAST, north.next());
    //}
    // Ostatni test rozbudowany o cale given when then
    @Test
    void ChangeDirectionToNextOne(){
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
    }
    @Test
    void ChangeDirectionToPreviousOne(){
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
    }
    @Test
    void ChangingDirectionToString(){
        assertEquals("Wschod", MapDirection.EAST.toString());
        assertEquals("Poludnie", MapDirection.SOUTH.toString());
        assertEquals("Zachod", MapDirection.WEST.toString());
        assertEquals("Polnoc", MapDirection.NORTH.toString());
    }
    @Test
    void ChangingDirectionToUnitVector()
    {
        //Given
        Vector2d ExpectedNorth = new Vector2d(0,1);
        Vector2d ExpectedWest = new Vector2d(-1,0);
        Vector2d ExpectedSouth = new Vector2d(0,-1);
        Vector2d ExpectedEast = new Vector2d(1,0);
        //When
        Vector2d north = MapDirection.NORTH.toUnitVector();
        Vector2d south = MapDirection.SOUTH.toUnitVector();
        Vector2d west = MapDirection.WEST.toUnitVector();
        Vector2d east = MapDirection.EAST.toUnitVector();
        //Then
        assertEquals(ExpectedNorth, north);
        assertEquals(ExpectedSouth, south);
        assertEquals(ExpectedWest, west);
        assertEquals(ExpectedEast, east);
    }
}