package kinopoisk.storage;

import kinopoisk.model.Directer;
import kinopoisk.model.Movie;
import kinopoisk.model.enums.AwardEnum;

import java.util.ArrayList;

public class MovieStorageArrayListImpl implements MovieStorage {
    private static final ArrayList<Movie> MOVIES = new ArrayList<>() {{
        add(new Movie("Batman Begins", 2005, 140, new Directer("Nolan", (short) 53), AwardEnum.OSCAR));
        add(new Movie("Inception", 2010, 148, new Directer("Fedor Christopher", (short) 54), AwardEnum.GOLDEN_RASPBERRY));
        add(new Movie("The Dark Knight", 2008, 167, new Directer("George Lucas", (short) 76), AwardEnum.GOLDEN_GLOBE));
    }};

    @Override
    public Movie[] getAll() {
        Movie[] moviesArray = new Movie[MOVIES.size()];
        for (int i = 0; i < MOVIES.size(); i++) {
            moviesArray[i] = MOVIES.get(i).clone();
        }
        return moviesArray;
    }

    @Override
    public Movie getById(int id) {
        if (id >= MOVIES.size() || id < 0) {
            throw new RuntimeException("ID с данным фильмом НЕТ!");
        }
        return MOVIES.get(id).clone();
    }

    @Override
    public void deleteById(int id) {
        if (id >= MOVIES.size() || id < 0) {
            throw new RuntimeException("ID с данным фильмом НЕТ! Ничего не удаляем");
        } else {
            MOVIES.remove(id);
        }
    }

    @Override
    public void add(Movie movie) {
        MOVIES.add(movie.clone());
    }

    @Override
    public void updateById(int id, Movie updatedMovie) {
        MOVIES.set(id, updatedMovie.clone());
    }
}
