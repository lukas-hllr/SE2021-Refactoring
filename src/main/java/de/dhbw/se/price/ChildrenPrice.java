package de.dhbw.se.price;

import de.dhbw.se.Movie;

public class ChildrenPrice extends Price {
    public int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    public double getPrice(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}