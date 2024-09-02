package kinopoisk.Hogwarts;

public class Hufflepuff implements Facultable {
public String titleFilm;

    public Hufflepuff(String titleFilm) {
        this.titleFilm = titleFilm;
    }

    public void printYourName() {
        System.out.println(titleFilm);
    }
}
