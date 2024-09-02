package kinopoisk.storage;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface BannedMovieStorage {
    void add(String bannedMovie) throws IOException, ClassNotFoundException;

    String[] getAll() throws IOException, ClassNotFoundException;

    /*Чтобы решить эту проблему, необходимо создать экземпляр класса и вызвать на нем метод myMethod(). Вот исправленный код:
    public class MyClass {
    void myMethod() {
        // некоторый код
    }

    public static void main(String[] args) {
        MyClass myObject = new MyClass();
        myObject.myMethod(); // теперь ошибки нет
    }

    Обычные методы привязаны к объектам (экземплярам) класса.
    Статические методы в Java — это методы уровня класса, которые принадлежат самому классу, а не его экземплярам.
}
    */
}
