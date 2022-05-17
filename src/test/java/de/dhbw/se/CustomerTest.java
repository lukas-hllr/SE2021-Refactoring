package de.dhbw.se;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer("Max");
        customer.addRental(new Rental(new Movie("Back to the Future", 0), 5));
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
                "\tBack to the Future\t\t5\t\t6.5\n"+
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points");

    }
}