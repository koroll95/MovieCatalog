package kinopoisk.storage;

import kinopoisk.model.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MovieStorageFileImpl implements MovieStorage {
    final File fileMovie = new File("resources//applicationMovieStorage.properties");

    @Override
    public Movie[] getAll() throws IOException, ClassNotFoundException {
        FileInputStream inputMovie = new FileInputStream(fileMovie);
        ObjectInputStream objectInputMovie = new ObjectInputStream(inputMovie);

        List MOVIES = (ArrayList) objectInputMovie.readObject();//чтение данных

        Movie[] moviesArray = new Movie[MOVIES.size()];
        for (int i = 0; i < MOVIES.size(); i++) {
            moviesArray[i] = (Movie) MOVIES.get(i);
        }
        objectInputMovie.close();
        return moviesArray;
    }

    @Override
    public Movie getById(int id) throws IOException, ClassNotFoundException {
        FileInputStream inputMovie = new FileInputStream(fileMovie);
        ObjectInputStream objectInputMovie = new ObjectInputStream(inputMovie);

        List MOVIES = (ArrayList) objectInputMovie.readObject();
        if (id >= MOVIES.size() || id < 0) {
            throw new RuntimeException("ID с данным фильмом НЕТ!");
        }
        objectInputMovie.close();
        return (Movie) MOVIES.get(id);
    }

    @Override
    public void deleteById(int id) throws IOException, ClassNotFoundException {
        FileInputStream inputMovie = new FileInputStream(fileMovie);
        ObjectInputStream objectInputMovie = new ObjectInputStream(inputMovie);

        List MOVIES = (ArrayList) objectInputMovie.readObject();
        if (id >= MOVIES.size() || id < 0) {
            throw new RuntimeException("ID с данным фильмом НЕТ! Ничего не удаляем");
        } else {
            MOVIES.remove(id);
        }
        FileOutputStream outputMovie = new FileOutputStream(fileMovie);
        ObjectOutputStream objectOutputMovie = new ObjectOutputStream(outputMovie);

        objectOutputMovie.writeObject(MOVIES);
        objectOutputMovie.close();
    }

    @Override
    public void add(Movie movie) throws IOException, ClassNotFoundException {
        FileInputStream inputMovie = new FileInputStream(fileMovie);
        ObjectInputStream objectInputMovie = new ObjectInputStream(inputMovie);

        List MOVIES = (ArrayList) objectInputMovie.readObject();
        MOVIES.add(movie);

        FileOutputStream outputMovie = new FileOutputStream(fileMovie);
        ObjectOutputStream objectOutputMovie = new ObjectOutputStream(outputMovie);

        objectOutputMovie.writeObject(MOVIES);
        objectOutputMovie.close();

    }

    @Override
    public void updateById(int id, Movie updatedMovie) throws IOException, ClassNotFoundException {
        FileInputStream inputMovie = new FileInputStream(fileMovie);
        ObjectInputStream objectInputMovie = new ObjectInputStream(inputMovie);

        List MOVIES = (ArrayList) objectInputMovie.readObject();
        MOVIES.set(id, updatedMovie.clone());

        FileOutputStream outputMovie = new FileOutputStream(fileMovie);
        ObjectOutputStream objectOutputMovie = new ObjectOutputStream(outputMovie);

        objectOutputMovie.writeObject(MOVIES);
        objectOutputMovie.close();
    }
}
