package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import java.util.*;

public class GrassField implements WorldMap {
    private final int grassNumber;
    private final int grassMaxSpawn;
    protected Vector2d lowerLeft = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private final MapVisualizer visualizer;
    private final Map<Vector2d, Animal> animals;
    private final Map<Vector2d, Grass> grasses;

    public GrassField(int grassNumber, List<Vector2d> positions) {
        this.grassNumber = grassNumber;
        this.grassMaxSpawn = (int) Math.sqrt(10 * this.grassNumber);
        this.animals = new HashMap<>();
        this.grasses = new HashMap<>();
        this.visualizer = new MapVisualizer(this);

        Random random = new Random();
        int i = 0;

        // Randomly spawn grass without overwriting specified positions
        while (i < this.grassNumber) {
            int x = random.nextInt(this.grassMaxSpawn + 1);
            int y = random.nextInt(this.grassMaxSpawn + 1);
            Vector2d newPosition = new Vector2d(x, y);

            if (!positions.contains(newPosition) && !grasses.containsKey(newPosition)) {
                grasses.put(newPosition, new Grass(newPosition));
                i++;
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);

        Vector2d newPosition = animal.getPosition();
        if (!newPosition.equals(oldPosition)) {
            animals.remove(oldPosition); // Remove from old position
            animals.put(newPosition, animal); // Add to new position
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position) || grasses.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        // Prioritize animals over grass
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        return grasses.get(position);
    }

    @Override
    public String toString() {
        Vector2d bottom = new Vector2d(upperRight.getX(), upperRight.getY());
        Vector2d top = new Vector2d(lowerLeft.getX(), lowerLeft.getY());

        for (Vector2d position : animals.keySet()) {
            bottom = bottom.lowerLeft(position);
            top = top.upperRight(position);
        }
        for (Vector2d position : grasses.keySet()) {
            bottom = bottom.lowerLeft(position);
            top = top.upperRight(position);
        }

        return visualizer.draw(bottom, top);
    }
}