package agh.ics.oop.model.util;

import agh.ics.oop.model.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class RandomPointsGenerator implements Iterable<Vector2d>{
    private final List<Vector2d> positions;
    public RandomPointsGenerator(int maxWidth, int maxHeight, int grassCount) {
        if (grassCount > maxWidth * maxHeight) {
            throw new IllegalArgumentException("Licz pol trawy nie moze byc wieksza od liczby pol na mapie");
        }
        positions = new ArrayList<>();
        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < maxHeight; y++) {
                positions.add(new Vector2d(x, y));
            }
        }

        Collections.shuffle(positions, new Random());

        while (positions.size() > grassCount) {
            positions.removeLast();
        }
    }
    @Override
    public Iterator<Vector2d> iterator() {
        return new RandomPositionIterator(positions);
    }
    private static class RandomPositionIterator implements Iterator<Vector2d> {
        private final List<Vector2d> positions;
        private int currentIndex = 0;

        public RandomPositionIterator(List<Vector2d> positions) {
            this.positions = positions;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < positions.size();
        }

        @Override
        public Vector2d next() {
            if (!hasNext()) {
                throw new IllegalStateException("Wszystkie punkty zostały użyte");
            }
               return positions.get(currentIndex++);
        }
    }
        // przechodzi testy, dziala (chyba)
}