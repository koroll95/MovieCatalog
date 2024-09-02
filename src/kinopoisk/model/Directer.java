package kinopoisk.model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Directer extends Person implements Serializable {

    private List<String> listFilms = new ArrayList<>();// спискок фильмов

    public Directer(String name, short age) {
        super(name, age);
    }

    public Directer(String name, short age, List listFilms) {
        super(name, age);
        this.listFilms = listFilms;
    }
}
