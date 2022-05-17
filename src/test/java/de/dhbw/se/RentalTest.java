package de.dhbw.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    private Rental rental;
    private Movie movie;

    @BeforeEach
    public void setup() {
        movie = new Movie("Star Wars I", Movie.REGULAR);
        rental = new Rental(movie, 3);
    }

    @Test
    public void testGetTitle() {
        assertEquals(rental.getMovie(), movie);
    }

    @Test
    public void testGetDays() {
        assertEquals(rental.getDaysRented(), 3);
    }
}