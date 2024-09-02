package kinopoisk.Testik;

public class Generics {
    public static void main(String[] args) {
        //Example <Integer> example = new Example<>();
       // Example <String> example = new Example<>();
        Example <Car> example = new Example<>();

       /* example.addToString(1);
        example.addToString(2);
        example.addToString(3);*/

       /* example.addToString("AAA");
        example.addToString("dd");
        example.addToString("fjdf");*/

        Car car1 = new Car("Vovlo",2024);
        Car car2 = new Car("Ford",2011);
        Car car3 = new Car("BMW",2005);

        example.addToString(car1);
        example.addToString(car2);
        example.addToString(car3);

        System.out.println(example.getString());
    }
}



