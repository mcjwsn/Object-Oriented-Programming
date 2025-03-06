package zwierzeta1_wersja_finalna;

public class Main {
    public static void main(String[] args) {
        PlywajceZwierzeta ptak1 = new Pingwin();
        LatajceZwierzeta ptak2 = new Bocian();

        System.out.println("\n");
        ptak2.fly();
        System.out.println("\n");
        ptak1.swim();
        System.out.println("\n");
    };

}