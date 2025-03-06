package wielokaty;

class Kwadrat extends Prostokat {
    //protected int szerokosc, wysokosc;
    @Override
    public void setWidth(int szerokosc) {
        this.szerokosc = this.wysokosc = szerokosc;
    }

    @Override
    public void setHeight(int wysokosc) {
        this.wysokosc = this.szerokosc = wysokosc;
    }
}
