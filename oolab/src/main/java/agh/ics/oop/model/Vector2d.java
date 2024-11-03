package agh.ics.oop.model;

import java.util.Objects;

public class Vector2d { // mozna zmienic na rekord i bedzie git, bez getterow
    private final int x,y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    // uzywam getterow tak jak bylo na przykladzie na tablicy na laborce, ale w tak prostym programie to
    // raczej tylko obniza sprawnosc/efektywnosc programu, szczegolnie ze gettery tutaj nie sa niezbedne
    public String toString ()
    {
        return "(" + this.x + ", " + this.y + ")";
    }

    public boolean precedes(Vector2d other){
        return this.x <= other.getX() && this.y <= other.getY();
    }

    public boolean follows(Vector2d other){
        return this.x >= other.getX() && this.y >= other.getY();
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.getX(), this.y + other.getY());
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x-other.getX(),this.y-other.getY());
    }

    public Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(this.x, other.getX()), Math.max(this.y, other.getY()));
    }

    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(this.x, other.getX()), Math.min(this.y, other.getY()));
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }

    //public int hashCode() {
    //    return 31 * x + y;
    //}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}