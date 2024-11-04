package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    void changingToString() {
        Animal animal = new Animal();
        assert animal.toString().equals("Animal orientation Polnoc, position (2, 2)");
    }

    @Test
    void checkingPosition() {
        Animal animal = new Animal();
        assert animal.isAt(new Vector2d(2, 2));
    }

    @Test
    void canMoveHere(){
        Animal animal = new Animal();
        Vector2d position = new Vector2d(3,3);
        assertTrue(animal.isAbleToMove(position));
    }

    @Test
    void cantMoveHere(){
        Animal animal = new Animal();
        Vector2d position = new Vector2d(5,5);
        assertFalse(animal.isAbleToMove(position));
    }

    @Test
    void cantMoveHereToo(){
        Animal animal = new Animal();
        Vector2d position = new Vector2d(-1,1);
        assertFalse(animal.isAbleToMove(position));
    }

}