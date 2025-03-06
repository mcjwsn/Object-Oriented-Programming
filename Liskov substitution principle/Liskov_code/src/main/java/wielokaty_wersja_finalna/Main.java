package wielokaty_wersja_finalna;


public class Main {
    public static void main(String[] args) {

        int a = 5;
        int b = 10;
        int c = 6;

        Shape prostokat = new Prostokat2(a, b);
        Shape kwadrat = new Kwadrat2(c);

        System.out.println("Prostokat Pole: " + prostokat.getPole()); // 50
        System.out.println("Kwadrat Pole: " + kwadrat.getPole());   // 36


        b+=1; // zwiększamy szerokość o 1
        c+=1; // zwiększamy szerokość o 1

        Shape prostokat2 = new Prostokat2(a, b);
        Shape kwadrat2 = new Kwadrat2(c);

        System.out.println("Prostokat Pole: " + prostokat2.getPole()); // 55
        System.out.println("Kwadrat Pole: " + kwadrat2.getPole());   // 49

    }
}
