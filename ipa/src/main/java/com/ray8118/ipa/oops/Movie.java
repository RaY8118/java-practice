// ### 🔷 **Problem 13 – Movie Class: Rating and Genre Analysis**

// Create a `Movie` class with:

// * `title` (String)
// * `genre` (String)
// * `rating` (double)
// * `duration` (int) - in minutes

// Write:

// 1. A method `findMoviesByGenre(Movie[] movies, String genre)` to return an array of movies belonging to the given genre. Return an empty array if none found.
// 2. A method `getHighestRatedMovie(Movie[] movies)` to return the movie with the highest rating. Return null if no movies exist.
// 3. A method `calculateAverageDurationByGenre(Movie[] movies, String genre)` to return the average duration of movies in the given genre. Return 0 if no movies in the genre exist.

// ---
package com.ray8118.ipa.oops;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String genre;
    private double rating;
    private int duration;

    public Movie() {
    }

    public Movie(String title, String genre, double rating, int duration) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Movie[] findMoviesByGenre(Movie[] movies, String genre) {
        if (movies == null) {
            return new Movie[0];
        }

        List<Movie> genreMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getGenre().equals(genre)) {
                genreMovies.add(movie);
            }
        }
        return genreMovies.toArray(new Movie[0]);
    }

    public Movie getHighestRatedMovie(Movie[] movies) {
        Movie highestRatedMovie = null;
        for (Movie movie : movies) {
            if (highestRatedMovie == null || movie.getRating() > highestRatedMovie.getRating()) {
                highestRatedMovie = movie;
            }
        }
        return highestRatedMovie;
    }

    public double calculateAverageDurationByGenre(Movie[] movies, String genre) {
        double totalDuration = 0;
        int count = 0;
        for (Movie movie : movies) {
            if (movie.getGenre().equals(genre)) {
                totalDuration += movie.getDuration();
                count++;
            }
        }
        return count == 0 ? 0 : (totalDuration / count);
    }
}
