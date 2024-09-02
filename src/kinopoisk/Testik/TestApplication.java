package kinopoisk.Testik;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestApplication {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<String> BANNED_MOVIE_NAMES = new ArrayList<>();
        BANNED_MOVIE_NAMES.add("boroda");
        BANNED_MOVIE_NAMES.add("Liga champions");
        BANNED_MOVIE_NAMES.add("9 rota");
        BANNED_MOVIE_NAMES.add("Penis");
        BANNED_MOVIE_NAMES.add("aaa");

        FileOutputStream outputBannedMovieNames = new FileOutputStream("resources//applicationBannedMovieStorage.properties");
        ObjectOutputStream objectOutputBannedMovieNames = new ObjectOutputStream(outputBannedMovieNames);

        objectOutputBannedMovieNames.writeObject(BANNED_MOVIE_NAMES);
        objectOutputBannedMovieNames.close(); //закрываем поток и освобождаем ресурсы

        FileInputStream inputBannedMovieNames = new FileInputStream("resources//applicationBannedMovieStorage.properties");
        ObjectInputStream objectInputBannedMovieNames = new ObjectInputStream(inputBannedMovieNames);

        List bannedM = (ArrayList) objectInputBannedMovieNames.readObject();//чтение данных
        for (Object i : bannedM) {
            System.out.println(i);
        }
    }
}
