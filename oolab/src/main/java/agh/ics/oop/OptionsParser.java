package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.Arrays;

public class OptionsParser {

    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] directions = new MoveDirection[args.length];
        int MovesCounter = 0;
        for (String arg : args) {
            switch (arg) {
                case "f" -> directions[MovesCounter] = MoveDirection.FORWARD;
                case "b" -> directions[MovesCounter] = MoveDirection.BACKWARD;
                case "l" -> directions[MovesCounter] = MoveDirection.LEFT;
                case "r" -> directions[MovesCounter] = MoveDirection.RIGHT;
                default -> MovesCounter-=1;
            }
            MovesCounter++;
        }
        return Arrays.copyOfRange(directions, 0, MovesCounter);
    }
}
