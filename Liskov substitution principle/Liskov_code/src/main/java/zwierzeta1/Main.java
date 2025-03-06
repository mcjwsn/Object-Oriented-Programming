package zwierzeta1;

public class Main {
    public static void main(String[] args) {
        Ptak ptak1 = new Pingwin();
        Ptak ptak2 = new Bocian();

        System.out.println("\n");
        ptak1.fly();
        ptak2.fly();
        System.out.println("\n");
        ptak1.swim();
        ptak2.swim();
        System.out.println("\n");
    };

}
