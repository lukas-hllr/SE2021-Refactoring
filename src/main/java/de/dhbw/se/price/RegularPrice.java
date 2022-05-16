package de.dhbw.se.price;

import de.dhbw.se.Movie;
import de.dhbw.se.price.Price;

public class RegularPrice extends Price {
    public int getPriceCode() {
        return Movie.REGULAR;
    }
}
