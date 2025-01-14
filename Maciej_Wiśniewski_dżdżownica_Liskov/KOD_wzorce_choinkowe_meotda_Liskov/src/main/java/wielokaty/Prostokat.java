package wielokaty;

class Prostokat {
    protected int szerokosc, wysokosc;

    public void setWidth(int szerokosc) { this.szerokosc = szerokosc; }
    public void setHeight(int wysokosc) { this.wysokosc = wysokosc; }

    public int getPole() { return szerokosc * wysokosc; }
}