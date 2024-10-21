package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {

    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] directions = new MoveDirection[args.length];
        int i = 0;
        for (String arg : args) {
            switch (arg) {
                case "f" -> directions[i] = MoveDirection.FORWARD;
                case "b" -> directions[i] = MoveDirection.BACKWARD;
                case "l" -> directions[i] = MoveDirection.LEFT;
                case "r" -> directions[i] = MoveDirection.RIGHT;
                default -> i-=1;
            }
            i++;
        }
        return Arrays.copyOfRange(directions, 0, i);
    }
}
