package kinopoisk.storage;

import java.util.ArrayList;
import java.util.List;

public class BannedMovieStorageListImpl implements BannedMovieStorage {

    private static final List<String> BANNED_MOVIE_NAMES = new ArrayList<>() {{
        add("boroda");
        add("Liga champions");
        add("9 rota");
        add("Penis");
        add("aaa");
    }};

    @Override
    public void add(String bannedMovie) {
        BANNED_MOVIE_NAMES.add(bannedMovie);
    }

    @Override
    public String[] getAll() {
        String[] bannedMovieNamesArray = new String[BANNED_MOVIE_NAMES.size()];
        bannedMovieNamesArray = BANNED_MOVIE_NAMES.toArray(bannedMovieNamesArray);
        return bannedMovieNamesArray;
    }
}
