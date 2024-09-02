package kinopoisk.Testik;

public class Example<T> { //условность, передаем некий объект и с ним работать
    private String string = "";

    public String getString() {
        return string;
    }

    public void addToString(T t) {
        if (this.string.equals("")) {
            this.string = this.string + t.toString();
        } else {
            this.string = this.string + "\n" + t.toString();
        }
    }
}
