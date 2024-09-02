package kinopoisk.storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BannedMovieStorageFileImpl implements BannedMovieStorage {
    final File fileBanned = new File("resources//applicationBannedMovieStorage.properties");
    @Override
    public void add(String bannedMovie) throws IOException, ClassNotFoundException {
        FileInputStream inputBannedMovieNames = new FileInputStream(fileBanned);
        ObjectInputStream objectInputBannedMovieNames = new ObjectInputStream(inputBannedMovieNames);

        List BANNED_MOVIE_NAMES = (ArrayList) objectInputBannedMovieNames.readObject();//чтение данных
        BANNED_MOVIE_NAMES.add(bannedMovie);

        FileOutputStream outputBannedMovieNames = new FileOutputStream(fileBanned);
        ObjectOutputStream objectOutputBannedMovieNames = new ObjectOutputStream(outputBannedMovieNames);

        objectOutputBannedMovieNames.writeObject(BANNED_MOVIE_NAMES);
        objectOutputBannedMovieNames.close();
    }

    @Override
    public String[] getAll() throws IOException, ClassNotFoundException {
        FileInputStream inputBannedMovieNames = new FileInputStream(fileBanned);
        ObjectInputStream objectInputBannedMovieNames = new ObjectInputStream(inputBannedMovieNames);

        List BANNED_MOVIE_NAMES = (ArrayList) objectInputBannedMovieNames.readObject();//чтение данных

        String[] bannedMovieNamesArray = new String[BANNED_MOVIE_NAMES.size()];
        bannedMovieNamesArray = (String[]) BANNED_MOVIE_NAMES.toArray(bannedMovieNamesArray);
        objectInputBannedMovieNames.close();

        return bannedMovieNamesArray;
    }
}
