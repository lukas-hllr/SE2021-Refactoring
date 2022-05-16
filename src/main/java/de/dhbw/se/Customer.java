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
    public String getName (){
        return name;
    };
    public String getStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        String result = String.format("Rental Record for %s\n", this.getName());
        result += "\tTitle\t\tDays\tAmount\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = amountFor(each);
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints ++;
            //show figures for this rental
            result += String.format("\t%s\t\t%d\t\t%.1f\n", each.getMovie().getTitle(), each.getDaysRented(), thisAmount);
            totalAmount += thisAmount;
        }
        //add footer lines
        result += String.format("Amount owed is %.1f\n", totalAmount);
        result += String.format("You earned %d frequent renter points", frequentRenterPoints);
        return result;
    }

    private double amountFor(Rental rental) {
        double result = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR -> {
                result += 2;
                if (rental.getDaysRented() > 2)
                    result += (rental.getDaysRented() - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> {
                result += rental.getDaysRented() * 3;
            }
            case Movie.CHILDREN -> {
                result += 1.5;
                if (rental.getDaysRented() > 3)
                    result += (rental.getDaysRented() - 3) * 1.5;
            }
        }
        return result;
    }
}