package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    void parse_f_toForward() {
        //Given
        String[] args = {"f"};
        MoveDirection[] expected = {MoveDirection.FORWARD};
        //When
        MoveDirection[] actual = OptionsParser.parse(args);
        //Then
        assertArrayEquals(expected, actual);
    }

    @Test
    void parse_b_toBackward() {
        //Given
        String[] args = {"b"};
        MoveDirection[] expected = {MoveDirection.BACKWARD};
        //When
        MoveDirection[] actual = OptionsParser.parse(args);
        //Then
        assertArrayEquals(expected, actual);
    }

    @Test
    void parse_l_toLeft() {
        //Given
        String[] args = {"l"};
        MoveDirection[] expected = {MoveDirection.LEFT};
        //When
        MoveDirection[] actual = OptionsParser.parse(args);
        //Then
        assertArrayEquals(expected, actual);
    }

    @Test
    void parse_r_toRight() {
        //Given
        String[] args = {"r"};
        MoveDirection[] expected = {MoveDirection.RIGHT};
        //When
        MoveDirection[] actual = OptionsParser.parse(args);
        //Then
        assertArrayEquals(expected, actual);
    }
}