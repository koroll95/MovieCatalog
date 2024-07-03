package kinopoisk.Hogwarts;

public class Hogwarts {

    public static void main(String[] args) {
        Facultable griffindor = new Griffindor("Griffindor");

        Facultable slytherin = new Slytherin("Slytherin");

        Facultable hufflepuff = new Hufflepuff("Hufflepuff");

        Facultable ravenclaw = new Ravenclaw("Ravenclaw");

        Facultable facultates[] = new Facultable[]{griffindor, slytherin, hufflepuff, ravenclaw};
        for (int i = 0; i < facultates.length; i++) {
            facultates[i].printYourName();
        }

        for (Facultable facultate : facultates) {
            facultate.printYourName();
        }
    }
}
