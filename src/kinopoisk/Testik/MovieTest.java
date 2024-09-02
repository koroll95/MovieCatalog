package kinopoisk.Testik;

import kinopoisk.model.Directer;
import kinopoisk.model.Movie;
import kinopoisk.model.enums.AwardEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MovieTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Movie> MOVIES = new ArrayList<>();
        MOVIES.add(new Movie("Batman Begins", 2005, 140, new Directer("Nolan", (short) 53), AwardEnum.OSCAR));
        MOVIES.add(new Movie("Inception", 2010, 148, new Directer("Fedor Christopher", (short) 54), AwardEnum.GOLDEN_RASPBERRY));
        MOVIES.add(new Movie("The Dark Knight", 2008, 167, new Directer("George Lucas", (short) 76), AwardEnum.GOLDEN_GLOBE));

        FileOutputStream outputMovie = new FileOutputStream("resources//applicationMovieStorage.properties");
        ObjectOutputStream objectOutputMovie = new ObjectOutputStream(outputMovie);

        objectOutputMovie.writeObject(MOVIES);
        objectOutputMovie.close(); //закрываем поток и освобождаем ресурсы

        FileInputStream inputMovie = new FileInputStream("resources//applicationMovieStorage.properties");
        ObjectInputStream objectInputMovie = new ObjectInputStream(inputMovie);

        List moviesFilms = (ArrayList) objectInputMovie.readObject();//чтение данных
        for (Object i : moviesFilms) {
            System.out.println(i);
        }
    }
}
