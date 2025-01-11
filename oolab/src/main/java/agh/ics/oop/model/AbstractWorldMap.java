package agh.ics.oop.model;

import agh.ics.oop.model.util.*;
import agh.ics.oop.model.util.MapVisualizer;
import java.util.*;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class AbstractWorldMap implements WorldMap {
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final MapVisualizer visualizer = new MapVisualizer(this);
    protected final List<MapChangeListener> observers = new ArrayList<>();
    protected final String id;
    public AbstractWorldMap() {
        this.id = UUID.randomUUID().toString();
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
      return !isOccupied(position);
    }

    @Override
    public void place(Animal animal) throws IncorrectPositionException {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            notifyObservers("Animal placed at " + animal.getPosition());
        } else{
        throw new IncorrectPositionException(animal.getPosition());}
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        Vector2d newPosition = animal.getPosition();
        animals.remove(oldPosition);
        animals.put(animal.getPosition(), animal);

        notifyObservers("Animal moved from " + oldPosition + " to " + animal.getPosition());
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Optional<WorldElement> objectAt(Vector2d position) {
        //System.out.println(animals.get(position));
        //System.out.println(Optional.ofNullable(animals.get(position)));
        return Optional.ofNullable(animals.get(position));
    }

    @Override
    public List<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }
    @Override
    public abstract Boundary getCurrentBounds();


    @Override
    public String toString() {
        Boundary currentBounds = getCurrentBounds();
        return visualizer.draw(currentBounds.lowerLeft(), currentBounds.upperRight());
    }

    public void addObserver(MapChangeListener observer) {
        observers.add(observer);
    }

    public void removeObserver(MapChangeListener observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(String message) {
        for (MapChangeListener observer : observers) {
            observer.mapChanged(this, message);
        }
    }
    @Override
    public String getId() {
        return id;
    }

    public Collection<WorldElement> getOrderedAnimals() {
        return animals.values().stream().sorted(Comparator.comparing((WorldElement animal) -> animal.getPosition().getX())
                .thenComparing((WorldElement animal) -> animal.getPosition().getY())).collect(Collectors.toList());
    }
}