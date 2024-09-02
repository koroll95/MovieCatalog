package kinopoisk.Hogwarts;

public class Slytherin implements Facultable {
public String titleFilm;

    public Slytherin(String titleFilm) {
        this.titleFilm = titleFilm;
    }

    public void printYourName() {
        System.out.println(titleFilm);
    }
}
