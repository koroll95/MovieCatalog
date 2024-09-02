package kinopoisk.Testik;

public class Car {
    private String model;
    private int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Модель " + model + ", год выпуска - " + year + ".";
    }
}
