package agh.ics.oop.model;

import java.util.*;

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> mapofGrass;
    public GrassField(int grassNumber) {
        this.mapofGrass = new HashMap<>();
        Random random = new Random();
        int i=0;
        while (i < grassNumber) {
            int x = random.nextInt((int) Math.sqrt(10 * grassNumber));
            int y = random.nextInt((int) Math.sqrt(10 * grassNumber));

            boolean flag = false;
            for (Vector2d position: mapofGrass.keySet()) {
                if (Objects.equals(position, new Vector2d(x, y))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                this.mapofGrass.put(new Vector2d(x,y), new Grass(new Vector2d(x, y)));
                i++;
            }

        }
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement object = super.objectAt(position);
        if(object != null) return object;
        return mapofGrass.get(position);
    }

    @Override
    public String toString() {
        Vector2d bottom = new Vector2d(upperRight.getX(), upperRight.getY());
        Vector2d top = new Vector2d(lowerLeft.getX(), lowerLeft.getY());
        List<WorldElement> elements = getElements();
        for (WorldElement element: elements) {
            bottom = bottom.lowerLeft(element.getPosition());
            top = top.upperRight(element.getPosition());
        }
        return visualizer.draw(bottom, top);
    }

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = super.getElements();
        elements.addAll(mapofGrass.values());
        return elements;
    }
}