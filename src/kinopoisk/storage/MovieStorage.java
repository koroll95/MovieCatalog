package kinopoisk.storage;

import kinopoisk.model.Movie;

public interface MovieStorage {
    Movie[] getAll();

    Movie getById(int id);

    void deleteById(int id);

    void add(Movie movie);

    void updateById(int id, Movie updatedMovie);
}
