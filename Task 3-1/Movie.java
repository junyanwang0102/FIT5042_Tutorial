package fit5042.tutex.week03;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Named;

@SessionScoped
@Named(value = "movie")
public class Movie implements Serializable {

    private String title;
    private int year;
    private String director;

    public Movie() {
    }

    public Movie(String title, int year, String director) {
        this.title = title;
        this.year = year;
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", year=" + year + ", director=" + director + '}';
    }

    public String getToString() {
        return toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
