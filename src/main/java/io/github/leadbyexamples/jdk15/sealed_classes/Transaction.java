package io.github.leadbyexamples.jdk15.sealed_classes;

import java.math.BigDecimal;

sealed abstract class Transaction permits DebitTransaction, CreditTransaction {

    static final BigDecimal TEN = BigDecimal.valueOf(10);
    static final BigDecimal NINETY = BigDecimal.valueOf(90);
    static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    static final BigDecimal THOUSANDS = BigDecimal.valueOf(1000);
    static final BigDecimal ONE_THOUSANDS_ONE = BigDecimal.valueOf(1001);

    protected final BigDecimal value;

    Transaction(BigDecimal value) {
        this.value = value;
    }

    abstract BigDecimal entry(BigDecimal amount);
}





