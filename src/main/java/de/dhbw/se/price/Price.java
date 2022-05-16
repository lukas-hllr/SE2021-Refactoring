package de.dhbw.se.price;

import de.dhbw.se.Movie;

public abstract class Price {
    public abstract int getPriceCode();

    public double getPrice(int daysRented) {
        double result = 0;
        switch (this.getPriceCode()) {
            case Movie.REGULAR -> {
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> {
                result += daysRented * 3;
            }
            case Movie.CHILDREN -> {
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
            }
        }
        return result;
    }
}

