package fit5042.tutex.week03;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * @author Messom
 */
@Named(value = "movieApplication")
@ApplicationScoped
public class MovieApplication {

    public static final String APP_TITLE = "Movie Browser";
    private ArrayList<Movie> movies;

    public MovieApplication() {
        movies = new ArrayList<>();
        movies.add(new Movie("The Lord of the Rings: The Fellowship of the Ring", 2001, "Peter Jackson"));
        movies.add(new Movie("Inception", 2010, "Christopher Nolan"));
        movies.add(new Movie("The Hunger Games", 2012, "Gary Ross"));
        movies.add(new Movie("Elysium", 2013, "Neill Blomkamp"));
        movies.add(new Movie("Pacific Rim", 2013, "Guillermo del Toro"));
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
