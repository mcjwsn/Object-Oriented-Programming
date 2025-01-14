package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OptionsParser {

    public static List<MoveDirection> parse(String[] args) {
        return Arrays.stream(args)
                .map(arg -> switch (arg) {
                    case "f" -> MoveDirection.FORWARD;
                    case "b" -> MoveDirection.BACKWARD;
                    case "r" -> MoveDirection.RIGHT;
                    case "l" -> MoveDirection.LEFT;
                    default -> throw new IllegalArgumentException(arg + " is not a legal move specification");
                })
                .toList();
    }
}
