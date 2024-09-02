package kinopoisk.model;

public class Actor extends Person {
    private int amountOfFeesForLife; //сумма всех гонораров за жизнь

    public Actor(String name, short age, int amountOfFeesForLife) {
        super(name, age);
        this.amountOfFeesForLife = amountOfFeesForLife;
    }
}
