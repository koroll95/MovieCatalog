package kinopoisk.service;

import kinopoisk.model.Directer;
import kinopoisk.model.Movie;

public class MovieService {
    public static void main(String[] args) {
        Directer directer = new Directer("Nolan", (short) 47);
        Directer directer2 = new Directer("Korolev",(short) 29);
        Directer directer3 = new Directer("Pakhomov",(short) 30);

        Movie movie = new Movie("Smeshariki", 2012, 124, new Directer("Pakhomov",(short) 30));
    }
}
