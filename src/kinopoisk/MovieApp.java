package kinopoisk;

import kinopoisk.storage.*;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;


class MovieApp {

    public static void main(String[] args) throws Exception {
        File file = new File("resources//application.properties"); //указание файла, который хранит свойства
        Properties properties = new Properties();
        properties.load(new FileReader(file));
        System.out.println(properties.getProperty("storage"));
        if (properties.getProperty("storage").equals("array")) {
            new MovieConsoleApp(new BannedMovieStorageListImpl(), new MovieStorageArrayListImpl()).run();
        } else if (properties.getProperty("storage").equals("list")) {
            new MovieConsoleApp(new BannedMovieStorageImpl(), new MovieStorageImpl()).run();
        } else if (properties.getProperty("storage").equals("file")) {
            new MovieConsoleApp(new BannedMovieStorageFileImpl(), new MovieStorageFileImpl()).run();
        }
    }
}

