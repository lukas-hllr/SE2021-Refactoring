package de.dhbw.se;

import java.lang.*;
import java.util.*;

class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<>();

    public Customer (String name) {
        this.name = name;
    };

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    };

    public String getName () {
        return name;
    };

    public String getStatement() {
        Enumeration<Rental> enum_rentals = rentals.elements();
        String result = String.format("Rental Record for %s\n", this.getName());
        result += "\tTitle\t\tDays\tAmount\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();
            //show figures for this rental
            result += String.format("\t%s\t\t%d\t\t%.1f\n", each.getMovie().getTitle(), each.getDaysRented(), each.getMoviePrice());
        }
        //add footer lines
        result += String.format("Amount owed is %.1f\n", getTotalCharge());
        result += String.format("You earned %d frequent renter points", getTotalFrequentRenterPoints());
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getMoviePrice();
        }
        return result;
    }

}