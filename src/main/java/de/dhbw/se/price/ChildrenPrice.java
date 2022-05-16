package de.dhbw.se.price;

import de.dhbw.se.Movie;

public class ChildrenPrice extends Price {
    public int getPriceCode() {
        return Movie.CHILDREN;
    }
}