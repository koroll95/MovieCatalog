package kinopoisk;

import kinopoisk.model.Directer;
import kinopoisk.model.Movie;
import kinopoisk.storage.BannedMovieStorageImpl;
import kinopoisk.storage.MovieStorageImpl;

import java.util.Scanner;

class MovieApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Что хотите сделать:");
            System.out.println("1 - Вывести все фильмы.");
            System.out.println("2 - Добавить фильм.");
            System.out.println("3 - Изменить фильм.");
            System.out.println("4 - Вывести самый длинный фильм.");
            System.out.println("5 - Удалить фильм.");
            System.out.println("6 - Вывести фильм по ID.");
            System.out.println("7 - Добавить фильм в базу забаненных.");
            System.out.println("0 - Выход.");
            System.out.print("Введите что хотите сделать: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Вы выбрали вывести все фильмы. Вот список фильмов:");
                    System.out.println("Список всех фильмов");
                    printFilms();
                    break;
                case 2:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Вы выбрали добавить новый фильм.");
                    System.out.println("Список имеющихся фильмов:");
                    printFilms();
                    System.out.println("Введите данные нового фильма. ");
                    BannedMovieStorageImpl banFilmsAdd = new BannedMovieStorageImpl();
                    String[] bannedFilmsAdd = banFilmsAdd.getAll();

                    System.out.print("Введите название фильма: ");
                    String titleApp = scanner.nextLine();
                    for (int i = 0; i < bannedFilmsAdd.length; i++) {
                        if (titleApp.equals(bannedFilmsAdd[i])) {
                            throw new Exception("Фильм в запретной базе");
                        }
                    }
                    System.out.print("Введите дату выхода фильма: ");
                    int releaseApp = scanner.nextInt();
                    System.out.print("Введите продолжительность фильма: ");
                    int runningApp = scanner.nextInt();
                    System.out.print("Введите имя режиссера фильма: ");
                    String directedName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Введите возраст режиссера");
                    Short directedAge = scanner.nextShort();
                    Directer directer = new Directer(directedName, directedAge);
                    Movie myFilmApp = new Movie(titleApp, releaseApp, runningApp, directer);
                    MovieStorageImpl myFilmAdd = new MovieStorageImpl();
                    myFilmAdd.add(myFilmApp);
                    System.out.println("Новый список фильмов: ");
                    printFilms();
                    break;
                case 3:
                    System.out.println("Вы выбрали изменить фильм");
                    System.out.println("Начальный список фильмов");
                    printFilms();
                    System.out.print("Введите номер фильма который хотите изменить: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    BannedMovieStorageImpl banFilmsAddd = new BannedMovieStorageImpl();
                    String[] bannedListFilms = banFilmsAddd.getAll();


                    System.out.print("Введите новое название фильма: ");
                    String title = sc.nextLine();
                    for (int i = 0; i < bannedListFilms.length; i++) {
                        if (title.equals(bannedListFilms[i])) {
                            throw new Exception("Фильм в запретной базе");
                        }
                    }

                    System.out.print("Введите новую дату выхода фильма: ");
                    int release = sc.nextInt();

                    System.out.print("Введите новую продолжительность фильма: ");
                    int running = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Введите имя нового режиссера фильма: ");
                    String updatedDirectedName = sc.nextLine();

                    System.out.println("Введите возраст нового режиссера: ");
                    Short updatedDirectedAge = sc.nextShort();

                    Directer updatedDirecter = new Directer(updatedDirectedName, updatedDirectedAge);
                    Movie myFilmsUpdate = new Movie(title, release, running, updatedDirecter);
                    MovieStorageImpl myFilmUpdateById = new MovieStorageImpl();
                    myFilmUpdateById.updateById(id, myFilmsUpdate);

                    System.out.println("Новый список фильмов: ");
                    printFilms();
                    break;
                case 4:
                    System.out.println("Вы выбрали вывести самый длинный фильм");
                    System.out.println("Список фильмов");
                    printFilms();
                    searchLongRunningFilms();
                    break;
                case 5:
                    System.out.println("Вы выбрали удалить фильм");
                    System.out.println("Начальный Список фильмов");
                    printFilms();
                    System.out.print("Выберете фильм, который хотите удалить: ");
                    id = sc.nextInt();
                    try {
                        MovieStorageImpl myFilmDeleteById = new MovieStorageImpl();
                        myFilmDeleteById.deleteById(id);
                    } catch (RuntimeException exc) {
                        System.out.println(exc.getMessage());
                    }
                    System.out.println("Список фильмов после удаления");
                    printFilms();
                    break;
                case 6:
                    System.out.println("Вы выбрали вывести фильм по ID");
                    System.out.print("Выберите ID фильма, который хотите вывести: ");
                    MovieStorageImpl myFilm = new MovieStorageImpl();
                    Movie[] myFilmId = myFilm.getAll();
                    try {
                        MovieStorageImpl myFilmGetById = new MovieStorageImpl();
                        myFilmGetById.getById(id = sc.nextInt());
                        System.out.println(myFilmId[id]);
                    } catch (RuntimeException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case 7:
                    Scanner ban = new Scanner(System.in);
                    System.out.println("Вы выбрали добавить фильм в базу забаненных.");
                    System.out.println("Начальный список фильмов в бане");
                    printBannedsFilms();
                    System.out.println("Введите новый забаненный фильм:");
                    String bannedFilmNew = ban.nextLine();
                    System.out.println(bannedFilmNew);

                    MovieStorageImpl myMovies = new MovieStorageImpl();
                    Movie[] myFilms = myMovies.getAll();

                    for (int i = 0; i < myFilms.length; i++) {
                        if (myFilms[i].getTitleFilm().equals(bannedFilmNew)) {
                            MovieStorageImpl myFilmDeleteById = new MovieStorageImpl();
                            myFilmDeleteById.deleteById(i);
                            System.out.println("Такой фильм есть в базе фильмов, поэтому его удаляем!");
                        }
                    }

                    BannedMovieStorageImpl banNewFilmsAdd = new BannedMovieStorageImpl();
                    banNewFilmsAdd.add(bannedFilmNew);

                    System.out.println("Новый список фильмов в бане");
                    printBannedsFilms();
                    break;
                case 0:
                    System.out.println("Вы вышли из программы");
                    break;
                default:
                    System.out.println("Запрос НЕ найден!");
            }
            if (choice == 0) {
                break;
            }
        }
    }

    private static void printFilms() { //метод вывода фильмов
        MovieStorageImpl myMovies = new MovieStorageImpl();
        Movie[] myFilms = myMovies.getAll();

        for (int i = 0; i < myFilms.length; i++) {
            System.out.println("ID фильма: " + i + " | " + myFilms[i]);
        }
    }


    private static void printBannedsFilms() { //метод вывода фильмов в бане
        BannedMovieStorageImpl banFilmsAdd = new BannedMovieStorageImpl();
        String[] bannedMovieNames = banFilmsAdd.getAll();
        for (int i = 0; i < bannedMovieNames.length; i++) {
            if (bannedMovieNames[i] != null) {
                System.out.println("Назввание забаненного фильма: " + bannedMovieNames[i]);
            }
        }
    }

    private static void searchLongRunningFilms() { //метод поиска самого продолжительного фильма
        MovieStorageImpl longRunningFilms = new MovieStorageImpl();
        Movie[] myFilms = longRunningFilms.getAll();

        int maxRunning = 0;
        for (int i = 0; i < myFilms.length; i++) {
            if (myFilms[i].getRunningTime() > maxRunning) {
                maxRunning = myFilms[i].getRunningTime();
            }
        }
        System.out.println("Самый длинный фильм: " + maxRunning + " мин");
    }
}
