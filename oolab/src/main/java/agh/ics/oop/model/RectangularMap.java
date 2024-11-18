package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    public RectangularMap(int width, int height){
        lowerLeft = new Vector2d(0,0);
        upperRight = new Vector2d(width-1, height-1);
    }
    @Override
    public String toString() {
        return visualizer.draw(lowerLeft, upperRight);
    }
}
