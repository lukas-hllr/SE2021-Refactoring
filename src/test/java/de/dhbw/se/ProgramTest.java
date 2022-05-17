package de.dhbw.se;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {
    @Test
    public void test() {

        String exp = "" +
                "Rental Record for Max\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tStar Wars I\t\t10\t\t30.0\n" +
                "\tStar Wars II\t\t5\t\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points";

        String result;
        Movie movie1 = new Movie("Star Wars I", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("Star Wars II", Movie.CHILDREN);
        Rental rental1 = new Rental(movie1, 10);
        Rental rental2 = new Rental(movie2, 5);
        Customer customer = new Customer("Max");
        customer.addRental(rental1);
        customer.addRental(rental2);
        result = customer.getStatement();
        assertEquals(exp, result);
    }
}