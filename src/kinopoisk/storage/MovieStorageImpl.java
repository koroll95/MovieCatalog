package kinopoisk.storage;

import kinopoisk.model.Directer;
import kinopoisk.model.Movie;
import kinopoisk.model.enums.AwardEnum;

public class MovieStorageImpl implements MovieStorage {
    private static Movie[] movies = new Movie[]{
            new Movie("Batman Begins", 2005, 140, new Directer("Nolan", (short) 53), AwardEnum.OSCAR),
            new Movie("Inception", 2010, 148, new Directer("Fedor Christopher", (short) 54), AwardEnum.GOLDEN_RASPBERRY),
            new Movie("The Dark Knight", 2008, 167, new Directer("George Lucas", (short) 76), AwardEnum.GOLDEN_GLOBE),
            null, null};

    public Movie[] getAll() { //возвращение массива
        Movie[] myFilmsNotNull = new Movie[countMovies()];
        for (int i = 0; i < myFilmsNotNull.length; i++) {
            myFilmsNotNull[i] = movies[i].clone();
        }
        return myFilmsNotNull;
    }

    private static int countMovies() {
        int size = 0;
        for (int i = 0; i < movies.length; i++) {
            if (movies[i] != null) {
                size++;
            }
        }
        return size;
    }


    public Movie getById(int id) throws RuntimeException { //возвращает копию объекта Movie
        if (id >= movies.length) {
            throw new RuntimeException("ID с данным фильмом НЕТ!");
        }
        return movies[id].clone();
    }

    public void deleteById(int id) throws RuntimeException { //метод удаления фильма
        if (id >= movies.length) {
            throw new RuntimeException("ID с данным фильмом НЕТ! Ничего не удаляем");
        }
        for (int i = id; i < movies.length - 1; i++) {
            movies[i] = movies[i + 1];
            movies[i + 1] = null;
        }
    }

    public void add(Movie movie) { //метод добавления фильма
        int size = countMovies();
        if (size == movies.length) {
            Movie[] newMovieArray = new Movie[movies.length * 2];
            for (int i = 0; i < movies.length; i++) {
                newMovieArray[i] = movies[i];
            }
            movies = newMovieArray;
        }
        movies[size] = movie;
    }

    public void updateById(int id, Movie updatedMovie) { //метод изменение фильма
        movies[id] = updatedMovie;
    }
}
