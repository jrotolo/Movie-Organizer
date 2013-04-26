import java.util.*;

public class MovieList {
	ArrayList<Movie> movies;

	public MovieList(ArrayList<Movie> movies) {
		movies = new ArrayList();
	}

	public void addMovie(Movie movieA) {
		movies.add(movieA);
	}

	public void removeMovie(Movie movieA) {
		movies.remove(movieA);
	}

	public Movie search(Movie movieA) {
		return null;	
	}

	public void sortByTitle() {
		// Sort the array by movie titles
	}

	public void sortByGenre(ArrayList<Movie> movies) {
		// Sort the array by movie genres
	}

	public void sortByYear(ArrayList<Movie> movies) {
		// Sort the array by movie years
	}

	public void sortByDirector(ArrayList<Movie> movies) {
		// Sort the array by movie.directors
	}

	public void sortByRating(ArrayList<Movie> movies) {
		// Sort the array by movie.rating
	}

}
