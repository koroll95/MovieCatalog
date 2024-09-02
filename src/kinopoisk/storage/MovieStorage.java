package kinopoisk.storage;

import kinopoisk.model.Movie;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface MovieStorage {
    Movie[] getAll() throws IOException, ClassNotFoundException;

    Movie getById(int id) throws IOException, ClassNotFoundException;

    void deleteById(int id) throws IOException, ClassNotFoundException;

    void add(Movie movie) throws IOException, ClassNotFoundException;

    void updateById(int id, Movie updatedMovie) throws IOException, ClassNotFoundException;
}
