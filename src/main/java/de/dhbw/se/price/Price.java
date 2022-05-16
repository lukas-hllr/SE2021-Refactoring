package de.dhbw.se.price;

public abstract class Price {
    public abstract int getPriceCode();

    public abstract double getPrice(int daysRented);
}

