package com.ray8118.ipa.oops;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    @DisplayName("Find movies by genre")
    public void testFindMoviesByGenre() {
        Movie[] movies = {
                new Movie("Inception", "Sci-Fi", 8.8, 148),
                new Movie("Interstellar", "Sci-Fi", 8.6, 169),
                new Movie("The Dark Knight", "Action", 9.0, 152)
        };

        Movie utils = new Movie();
        Movie[] sciFiMovies = utils.findMoviesByGenre(movies, "Sci-Fi");

        assertEquals(2, sciFiMovies.length);
        assertEquals("Inception", sciFiMovies[0].getTitle());
        assertEquals("Interstellar", sciFiMovies[1].getTitle());
    }

    @Test
    @DisplayName("Return empty array when no movies match genre")
    public void testFindMoviesByGenre_NoMatch() {
        Movie[] movies = {
                new Movie("Inception", "Sci-Fi", 8.8, 148)
        };

        Movie utils = new Movie();
        Movie[] result = utils.findMoviesByGenre(movies, "Comedy");

        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("Get highest rated movie")
    public void testGetHighestRatedMovie() {
        Movie[] movies = {
                new Movie("Inception", "Sci-Fi", 8.8, 148),
                new Movie("Interstellar", "Sci-Fi", 8.6, 169),
                new Movie("The Dark Knight", "Action", 9.0, 152)
        };

        Movie utils = new Movie();
        Movie bestMovie = utils.getHighestRatedMovie(movies);

        assertEquals("The Dark Knight", bestMovie.getTitle());
        assertEquals(9.0, bestMovie.getRating());
    }

    @Test
    @DisplayName("Return null when no movies exist")
    public void testGetHighestRatedMovie_Empty() {
        Movie[] movies = {};
        Movie utils = new Movie();
        Movie bestMovie = utils.getHighestRatedMovie(movies);
        assertEquals(null, bestMovie);
    }

    @Test
    @DisplayName("Calculate average duration by genre")
    public void testCalculateAverageDurationByGenre() {
        Movie[] movies = {
                new Movie("Inception", "Sci-Fi", 8.8, 148),
                new Movie("Interstellar", "Sci-Fi", 8.6, 169),
                new Movie("The Dark Knight", "Action", 9.0, 152)
        };

        Movie utils = new Movie();
        double avg = utils.calculateAverageDurationByGenre(movies, "Sci-Fi");

        assertEquals(158.5, avg);
    }

    @Test
    @DisplayName("Return 0 average for missing genre")
    public void testCalculateAverageDurationByGenre_NoMatch() {
        Movie[] movies = {
                new Movie("Inception", "Sci-Fi", 8.8, 148)
        };

        Movie utils = new Movie();
        double avg = utils.calculateAverageDurationByGenre(movies, "Horror");

        assertEquals(0.0, avg);
    }
}
