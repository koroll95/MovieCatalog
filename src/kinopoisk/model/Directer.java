package kinopoisk.model;

public class Directer extends Person{
    private String name; //имя режиссера
    private short age; //возраст режиссера
    private String List; //списком фильмов

    public Directer(String name, short age) {
        this.age = age;
        this.name = name;

    }

    public String toString() {
        return "Имя: " + name + ", возраст: " + age;
    }
}
