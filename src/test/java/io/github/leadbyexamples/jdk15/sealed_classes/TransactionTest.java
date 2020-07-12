package io.github.leadbyexamples.jdk15.sealed_classes;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {

    @Test
    void shouldDebited() {
        DebitTransaction transaction = new DebitTransaction(Transaction.HUNDRED);

        BigDecimal actual = transaction.entry(Transaction.TEN);

        assertEquals(Transaction.NINETY, actual);
    }

    @Test
    void shouldCredited() {
        CreditTransaction transaction = new CreditTransaction(Transaction.THOUSANDS);

        BigDecimal actual = transaction.entry(BigDecimal.ONE);

        assertEquals(Transaction.ONE_THOUSANDS_ONE, actual);
    }

}