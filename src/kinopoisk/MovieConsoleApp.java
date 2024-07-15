package kinopoisk;

import kinopoisk.model.Directer;
import kinopoisk.model.Movie;
import kinopoisk.storage.BannedMovieStorage;
import kinopoisk.storage.MovieStorage;
import kinopoisk.storage.MovieStorageArrayListImpl;
import kinopoisk.storage.BannedMovieStorageListImpl;
import java.util.Scanner;

public class MovieConsoleApp {
    private BannedMovieStorage bannedMovieStorage;
    private BannedMovieStorageListImpl bannedMovieStorageListImpl;
    private MovieStorage movieStorage;
    private MovieStorageArrayListImpl movieStorageArrayListImpl;

    //public MovieConsoleApp(BannedMovieStorage bannedMovieStorage, MovieStorage movieStorage) {
        //this.bannedMovieStorage = bannedMovieStorage;
        //this.movieStorage = movieStorage;
   // }

    public MovieConsoleApp(BannedMovieStorageListImpl bannedMovieStorageListImpl, MovieStorageArrayListImpl movieStorageArrayListImpl) {
        this.bannedMovieStorageListImpl = bannedMovieStorageListImpl;
        this.movieStorageArrayListImpl = movieStorageArrayListImpl;
    }

    public void run() throws Exception {
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

                    //String[] bannedFilmsAdd = bannedMovieStorage.getAll();
                    String[] bannedFilmsAdd = bannedMovieStorageListImpl.getAll();

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
                    System.out.println("Введите возраст режиссера: ");
                    Short directedAge = scanner.nextShort();
                    Directer directer = new Directer(directedName, directedAge);
                    Movie myFilmApp = new Movie(titleApp, releaseApp, runningApp, directer);
                    //movieStorage.add(myFilmApp);
                    movieStorageArrayListImpl.add(myFilmApp);
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
                    //String[] bannedListFilms = bannedMovieStorage.getAll();
                    String[] bannedListFilms = bannedMovieStorageListImpl.getAll();


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
                   //movieStorage.updateById(id, myFilmsUpdate);
                    movieStorageArrayListImpl.updateById(id, myFilmsUpdate);

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
                        //movieStorage.deleteById(id);
                        movieStorageArrayListImpl.deleteById(id);
                    } catch (RuntimeException exc) {
                        System.out.println(exc.getMessage());
                    }
                    System.out.println("Список фильмов после удаления");
                    printFilms();
                    break;
                case 6:
                    System.out.println("Вы выбрали вывести фильм по ID");
                    System.out.print("Выберите ID фильма, который хотите вывести: ");
                    //Movie[] myFilmId = movieStorage.getAll();
                    Movie[] myFilmId = movieStorageArrayListImpl.getAll();
                    try {
                        //movieStorage.getById(id = sc.nextInt());
                        movieStorageArrayListImpl.getById(id = sc.nextInt());
                        System.out.println(myFilmId[id]);
                    } catch (RuntimeException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case 7:
                    Scanner ban = new Scanner(System.in);
                    System.out.println("Вы выбрали добавить фильм в базу забаненных.");
                    System.out.println("Начальный список фильмов в бане");
                    printBannedFilms();
                    System.out.println("Введите новый забаненный фильм:");
                    String bannedFilmNew = ban.nextLine();
                    //Movie[] myFilms = movieStorage.getAll();
                    Movie[] myFilms = movieStorageArrayListImpl.getAll();

                    for (int i = 0; i < myFilms.length; i++) {
                        if (myFilms[i].getTitleFilm().equals(bannedFilmNew)) {
                            //movieStorage.deleteById(i);
                            movieStorageArrayListImpl.deleteById(i);
                            System.out.println("Такой фильм есть в базе фильмов, поэтому его удаляем!");
                        }
                    }
                    //bannedMovieStorage.add(bannedFilmNew);
                    bannedMovieStorageListImpl.add(bannedFilmNew);

                    System.out.println("Новый список фильмов в бане");
                    printBannedFilms();
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


    private void printFilms() { //метод вывода фильмов
        //Movie[] myFilms = movieStorage.getAll();
        Movie[] myFilms = movieStorageArrayListImpl.getAll();
        for (int i = 0; i < myFilms.length; i++) {
            System.out.println("ID фильма: " + i + " | " + myFilms[i]);
        }
    }


    private void printBannedFilms() { //метод вывода фильмов в бане
        //String[] bannedMovieNames = bannedMovieStorage.getAll();
        String[] bannedMovieNames = bannedMovieStorageListImpl.getAll();
        for (int i = 0; i < bannedMovieNames.length; i++) {
            if (bannedMovieNames[i] != null) {
                System.out.println("Назввание забаненного фильма: " + bannedMovieNames[i]);
            }
        }
    }

    private void searchLongRunningFilms() { //метод поиска самого продолжительного фильма
        //Movie[] myFilms = movieStorage.getAll();
        Movie[] myFilms = movieStorageArrayListImpl.getAll();
        int maxRunning = 0;
        for (int i = 0; i < myFilms.length; i++) {
            if (myFilms[i].getRunningTime() > maxRunning) {
                maxRunning = myFilms[i].getRunningTime();
            }
        }
        System.out.println("Самый длинный фильм: " + maxRunning + " мин");
    }
}
