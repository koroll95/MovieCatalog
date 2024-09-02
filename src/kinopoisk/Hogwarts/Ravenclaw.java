package kinopoisk.Hogwarts;

public class Ravenclaw implements Facultable {
public String titleFilm;

    public Ravenclaw(String titleFilm) {
        this.titleFilm = titleFilm;
    }

    public void printYourName() {
        System.out.println(titleFilm);
    }
}
