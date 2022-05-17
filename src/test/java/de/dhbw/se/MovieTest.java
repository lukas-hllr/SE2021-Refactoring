package de.dhbw.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    private Movie movie;

    @BeforeEach
    public void setup() {
        movie = new Movie("Back to the Future", Movie.REGULAR);
    }

    @Test
    public void testGetPriceCode() {
        assertEquals(movie.getPriceCode(), Movie.REGULAR);
    }

    @Test
    public void testSetPriceCode() {
        movie.setPriceCode(Movie.CHILDREN);
        assertEquals(movie.getPriceCode(), Movie.CHILDREN);
    }

    @Test
    public void testGetTitle() {
        assertEquals(movie.getTitle(), "Back to the Future");
    }




}