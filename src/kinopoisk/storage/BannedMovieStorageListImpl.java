package kinopoisk.storage;

import java.util.ArrayList;

public class BannedMovieStorageListImpl implements BannedMovieStorage {

    private static ArrayList<String> bannedMovieNames = new ArrayList();

    static {
        bannedMovieNames.add("boroda");
        bannedMovieNames.add("Liga champions");
        bannedMovieNames.add("9 rota");
        bannedMovieNames.add("Penis");
        bannedMovieNames.add("aaa");
    }

    @Override
    public void add(String bannedMovie) {
        bannedMovieNames.add(bannedMovie);

    }

    @Override
    public String[] getAll() {
        String[] bannedMovieNamesArray = new String[bannedMovieNames.size()];
        bannedMovieNamesArray = bannedMovieNames.toArray(bannedMovieNamesArray);
        return bannedMovieNamesArray.clone();
    }
}
