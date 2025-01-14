package agh.ics.oop.model;

import agh.ics.oop.model.util.IncorrectPositionException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbstractWorldMapTest {
    private void testOrderOfAnimals(List<Vector2d> startPosition, List<Vector2d> finishPosition){
        WorldMap worldMap = new GrassField((10));
        try {
            for (Vector2d position : startPosition) {
                worldMap.place(new Animal(MapDirection.NORTH,position));
            }
        } catch (IncorrectPositionException ignored) {}

        Collection<WorldElement> orderedAnimals = worldMap.getOrderedAnimals();

        List<Vector2d> actualPositions = new ArrayList<>();
        for (WorldElement animal : orderedAnimals) {
            actualPositions.add(animal.getPosition());
        }
        assertEquals(finishPosition, actualPositions);

    }

    @Test
    void testGetOrderedAnimals() {
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(1, 2);
        Vector2d vector3 = new Vector2d(3, 1);
        Vector2d vector4 = new Vector2d(2, 2);
        Vector2d vector5 = new Vector2d(1, 1);
        Vector2d vector6 = new Vector2d(1, 3);
        Vector2d vector7 = new Vector2d(3, 3);
        Vector2d vector8 = new Vector2d(3, 2);
        testOrderOfAnimals(List.of(vector1, vector2, vector3, vector4), List.of(vector2, vector4, vector1, vector3));
        testOrderOfAnimals(List.of(vector1, vector4), List.of(vector4, vector1));
        testOrderOfAnimals(List.of(vector1, vector5, vector7, vector8), List.of(vector5, vector1, vector8, vector7));
        testOrderOfAnimals(List.of(vector1, vector2, vector3, vector4, vector5, vector6, vector7, vector8),
                List.of(vector5, vector2, vector6, vector4, vector1, vector3, vector8, vector7));
    }

}