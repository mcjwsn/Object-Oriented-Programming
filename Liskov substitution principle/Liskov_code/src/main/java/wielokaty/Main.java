package wielokaty;

public class Main {
    public static void main(String[] args) {

        Prostokat p1 = new Prostokat();
        Prostokat p2 = new Kwadrat();

        int a = 5;
        int b = 10;
        int c = 6;

        p1.setWidth(a);
        p1.setHeight(b);
        System.out.println("Pole: " + p1.getPole());

        p2.setWidth(c);
        p2.setHeight(c);
        System.out.println("Pole: " + p2.getPole());

        b+=1; // zwiększamy szerokość o 1
        c+=1; // zwiększamy szerokość o 1

        p1.setHeight(b);
        p2.setHeight(c);


        System.out.println("Pole: " + p1.getPole());
        System.out.println("Pole: " + p2.getPole());

    }
}