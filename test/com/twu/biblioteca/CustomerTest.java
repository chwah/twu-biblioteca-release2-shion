package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shion on 21/4/16.
 */
public class CustomerTest {
    @Test
    public void customerIsValid() {
        Customer customer = new Customer("123-4567", "password", "Name", "name@email.com", "12345678");
        assertTrue(customer.isValidCustomer() == true);
    }

    @Test
    public void librarianIsNotValid() {
        Customer customer1 = new Customer("123-45678", "password", "Name 1", "name1@email.com", "12345678");
        Customer customer2 = new Customer("123-4567", "password", "Name 1", "name1_email.com", "12345678");
        Customer customer3 = new Customer("123-4567", "password", "Name 1", "name1@email.com", "123456789");

        assertTrue(customer1.isValidCustomer() == false);
        assertTrue(customer2.isValidCustomer() == false);
        assertTrue(customer3.isValidCustomer() == false);
    }
}