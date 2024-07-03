package kinopoisk.storage;

public class BannedMovieStorageImpl implements BannedMovieStorage{
    static String[] bannedMovieNames = new String[]{"boroda", "Liga champions", "9 rota", "Penis", "aaa", null, null};

    public String[] getAll() {
        return bannedMovieNames.clone();
    }

    private static int countMovies() {
        int size = 0;
        for (int i = 0; i < bannedMovieNames.length; i++) {
            if (bannedMovieNames[i] != null) {
                size++;
            }
        }
        return size;
    }

    public void add(String bannedMovie) { //метод добавления фильма
        int size = countMovies();
        if (size == bannedMovieNames.length) {
            String[] bannedNewFilms = new String[bannedMovieNames.length * 2];
            for (int i = 0; i < bannedMovieNames.length; i++) {

                bannedNewFilms[i] = bannedMovieNames[i];
            }
            bannedMovieNames = bannedNewFilms;
        }
        bannedMovieNames[size] = bannedMovie;

    }
}
