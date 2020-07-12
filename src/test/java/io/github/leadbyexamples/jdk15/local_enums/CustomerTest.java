package io.github.leadbyexamples.jdk15.local_enums;

import org.junit.jupiter.api.Test;

import static io.github.leadbyexamples.jdk15.local_enums.Customer.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    void testLocalEnums() {
        Customer customer = new Customer("A", CustomerStatus.ACTIVE);

        assertEquals("A", customer.getName());
        assertEquals(CustomerStatus.ACTIVE, customer.getStatus());
    }
}