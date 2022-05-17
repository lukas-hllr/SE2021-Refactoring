package de.dhbw.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer("Max");
        customer.addRental(new Rental(new Movie("Star Wars I", Movie.REGULAR), 5));
    }

    @Test
    public void testGetName() {
        assertEquals(customer.getName(), "Max");

    }

    @Test
    public void testStatement() {
        assertEquals(customer.getStatement(),"" +
                "Rental Record for Max\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tStar Wars I\t\t5\t\t6.5\n"+
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points");

    }
}