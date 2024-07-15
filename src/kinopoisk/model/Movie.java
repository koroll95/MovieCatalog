package kinopoisk.model;

import kinopoisk.model.enums.AwardEnum;
import java.util.ArrayList;

public class Movie implements Cloneable {
    private String titleFilm; //название фильма
    private int releaseDates; //дата выхода
    private int runningTime; //продолжительность фильма
    private Directer directed; //режиссер
    private AwardEnum award; // награда

    public Movie(String titleFilm, int releaseDates, int runningTime, Directer directed) {
        this.titleFilm = titleFilm;
        this.releaseDates = releaseDates;
        this.runningTime = runningTime;
        this.directed = directed;
    }

    public Movie() {

    }

    public Movie(String titleFilm, int releaseDates, int runningTime, Directer directed, AwardEnum award) {
        this.titleFilm = titleFilm;
        this.releaseDates = releaseDates;
        this.runningTime = runningTime;
        this.directed = directed;
        this.award = award;
    }

    public int getRunningTime() { // Get позволяет получить значения (читать значения)
        return runningTime;
    }

    public String getTitleFilm() {
        return titleFilm;
    }

    public Directer getDirected() {
        return directed;
    }

    public int getReleaseDates() {
        return releaseDates;
    }

    public void setRunningTime(int runningTime) { // Set — записать значения в переменную
        this.runningTime = runningTime;
    }

    public String toString() {
        return "Название фильма: " + titleFilm + " | Дата выхода фильма: " + releaseDates + " год | Продолжительность фильма: " + runningTime + " мин | Режиссер фильма: " + directed + " | Награды фильма: " + award;
    }

    public Movie clone() {
        try {
            return (Movie) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}
