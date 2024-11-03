package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;
//Uzywam ArrayList
//szybsza dostepnosc, lepsza wydajnosc, dostep do ruchow przez index w OptionParser
// nie dodajemy/usuwamy elementow wiec arraylist jest lepsze od linkedlist
public class Simulation {
    private final  List<Animal> animals;
    private final List<MoveDirection> directions;

    public Simulation(List<MoveDirection> directions,List<Vector2d> positions) {
        this.animals = new ArrayList<>();
        for (Vector2d position : positions) {
            animals.add(new Animal(MapDirection.NORTH, position));
        }
        this.directions = directions;
    }
    public void run(){
        for(int i=0;i<directions.size();i++){
            Animal currentAnimal = animals.get(i % animals.size());
            MoveDirection direction = directions.get(i);

            currentAnimal.move(direction);

            System.out.println("zwierze " + i % animals.size() + ": " + currentAnimal);
        }

    }
    public List<Animal> getAnimals() {
        return animals;
    }
}

