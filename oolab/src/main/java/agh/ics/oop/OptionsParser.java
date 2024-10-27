package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.Arrays;

public class OptionsParser {

    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] directions = new MoveDirection[args.length];
        int IndexCounter = 0;
        for (String arg : args) {
            switch (arg) {
                case "f" -> directions[IndexCounter] = MoveDirection.FORWARD;
                case "b" -> directions[IndexCounter] = MoveDirection.BACKWARD;
                case "l" -> directions[IndexCounter] = MoveDirection.LEFT;
                case "r" -> directions[IndexCounter] = MoveDirection.RIGHT;
                default -> IndexCounter -=1;
            }
            IndexCounter++;
        }
        return Arrays.copyOfRange(directions, 0, IndexCounter);
    }
}
