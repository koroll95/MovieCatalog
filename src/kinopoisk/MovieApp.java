package kinopoisk;

import kinopoisk.storage.BannedMovieStorageImpl;
import kinopoisk.storage.MovieStorageImpl;
import kinopoisk.storage.BannedMovieStorageListImpl;
import kinopoisk.storage.MovieStorageArrayListImpl;

class MovieApp {

    public static void main(String[] args) throws Exception {
        new MovieConsoleApp(new BannedMovieStorageListImpl(),new MovieStorageArrayListImpl()).run();
        //new MovieConsoleApp(new BannedMovieStorageImpl(),new MovieStorageImpl()).run();
    }

}
