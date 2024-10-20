package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import static agh.ics.oop.OptionsParser.parse;
public class World {
    public static void run(MoveDirection[] args){
        //System.out.println("Zwierzak idzie do przodu");
        //for(int i=0;i<args.length-1;i++)
        //{
        //    System.out.printf(args[i]);
        //    System.out.printf(", ");
        //}
        //System.out.printf(args[args.length-1]);
        //System.out.println();
        for(MoveDirection arg : args) {
            String output = switch (arg) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tylu";
                case RIGHT -> "Zwierzak idzie w prawo";
                case LEFT -> "Zwierzak idzie w lewo";
            };
            System.out.println(output);
        }
    }
    public static void main(String[] args) {
        //System.out.println("System wystartowal);
        MoveDirection[] directions = parse(args);
        System.out.println("Start");
        run(directions);
        System.out.println("Stop");
    }
}