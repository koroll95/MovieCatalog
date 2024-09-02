package kinopoisk.model;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String name; //имя
    private short age; //возраст


    public Person(String name, short age) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "Имя: " + name + ", возраст: " + age;
    }
}
