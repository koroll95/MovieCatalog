package kinopoisk.storage;

import kinopoisk.model.Directer;
import kinopoisk.model.Movie;
import kinopoisk.model.enums.AwardEnum;

import java.util.ArrayList;

public class MovieStorageArrayListImpl implements MovieStorage {
    private static ArrayList<Movie> movies = new ArrayList<>();

    static {
        movies.add(new Movie("Batman Begins", 2005, 140, new Directer("Nolan", (short) 53), AwardEnum.OSCAR));
        movies.add(new Movie("Inception", 2010, 148, new Directer("Fedor Christopher", (short) 54), AwardEnum.GOLDEN_RASPBERRY));
        movies.add(new Movie("The Dark Knight", 2008, 167, new Directer("George Lucas", (short) 76), AwardEnum.GOLDEN_GLOBE));
    }

    @Override
    public Movie[] getAll() {
        Movie[] moviesArray = new Movie[movies.size()];
        for (int i = 0; i < movies.size(); i++) {
            moviesArray[i] = movies.get(i).clone();
        }
        return moviesArray;
    }

    @Override
    public Movie getById(int id) {
        if (id >= movies.size() || id < 0) {
            throw new RuntimeException("ID с данным фильмом НЕТ!");
        }
        return movies.get(id).clone();
    }

    @Override
    public void deleteById(int id) {
        if (id >= movies.size()) {
            throw new RuntimeException("ID с данным фильмом НЕТ! Ничего не удаляем");
        } else {
            movies.remove(id);
        }
    }

    @Override
    public void add(Movie movie) {
        movies.add(movie);
    }

    @Override
    public void updateById(int id, Movie updatedMovie) {
        movies.set(id, updatedMovie);
    }
}
