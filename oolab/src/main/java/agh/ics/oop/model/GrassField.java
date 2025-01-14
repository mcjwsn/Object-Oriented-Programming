package agh.ics.oop.model;

import agh.ics.oop.model.util.*;
import agh.ics.oop.model.util.RandomPointsGenerator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> mapOfGrass = new HashMap<>();
    private final List<MapChangeListener> observers = new ArrayList<>();
    public GrassField(int grassNumber) {
        generateGrass(grassNumber);
    }

    private void generateGrass(int grassNumber){
        RandomPointsGenerator randomPositionGenerator = new RandomPointsGenerator((int) Math.sqrt(10 * grassNumber), (int) Math.sqrt(10 * grassNumber), 2 * grassNumber);
        for (Vector2d grassPosition : randomPositionGenerator) {
            mapOfGrass.put(grassPosition, new Grass(grassPosition));
        }
    }

    @Override
    public Optional<WorldElement> objectAt(Vector2d position) {
        return super.objectAt(position)
                .or(() -> Optional.ofNullable(mapOfGrass.get(position)));
    }

    @Override
    public boolean isOccupied(Vector2d position){
        if(!super.isOccupied(position)){
            return mapOfGrass.containsKey(position);
        }
        return true;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public Boundary getCurrentBounds() {
        Vector2d bottom = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d top = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        List<WorldElement> elements = getElements();
        for (WorldElement element: elements) {
            bottom = bottom.lowerLeft(element.getPosition());
            top = top.upperRight(element.getPosition());
        }
        return new Boundary(bottom, top);
    }

    @Override
    public List<WorldElement> getElements() {
        return Stream.concat(animals.values().stream(), mapOfGrass.values().stream())
                .collect(Collectors.toList());
    }
}