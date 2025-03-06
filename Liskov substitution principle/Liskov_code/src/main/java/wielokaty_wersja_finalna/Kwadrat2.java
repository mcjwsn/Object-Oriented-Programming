package wielokaty_wersja_finalna;

public class Kwadrat2 implements Shape {
    private int bok;

    public Kwadrat2(int bok) { this.bok = bok; }

    @Override
    public int getPole() { return bok * bok; }
}
