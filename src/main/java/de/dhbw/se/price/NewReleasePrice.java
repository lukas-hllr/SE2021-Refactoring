package de.dhbw.se.price;

import de.dhbw.se.Movie;

public class NewReleasePrice extends Price {
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}
