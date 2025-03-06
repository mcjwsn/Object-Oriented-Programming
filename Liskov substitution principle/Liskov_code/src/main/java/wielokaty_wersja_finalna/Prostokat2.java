package wielokaty_wersja_finalna;

public class Prostokat2 implements Shape {
    protected int szerokosc, wysokosc;

    public Prostokat2(int szerokosc, int wysokosc) {
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    @Override
    public int getPole() { return szerokosc * wysokosc; }
}
