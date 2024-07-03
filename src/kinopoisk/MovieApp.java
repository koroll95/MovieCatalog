package kinopoisk;

import kinopoisk.storage.BannedMovieStorageImpl;
import kinopoisk.storage.MovieStorageImpl;

class MovieApp {

    public static void main(String[] args) throws Exception {
        new MovieConsoleApp(new BannedMovieStorageImpl(),new MovieStorageImpl()).run();
    }
}
