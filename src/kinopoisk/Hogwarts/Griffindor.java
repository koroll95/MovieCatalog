package kinopoisk.Hogwarts;

public class Griffindor implements Facultable {
public String titleFilm;

    public Griffindor(String titleFilm) {
        this.titleFilm = titleFilm;
    }

    public void printYourName() {
        System.out.println(titleFilm);
    }
}