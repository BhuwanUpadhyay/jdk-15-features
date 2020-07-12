package io.github.leadbyexamples.jdk15.sealed_classes;

import java.math.BigDecimal;

final class CreditTransaction extends Transaction {

    public CreditTransaction(BigDecimal baseAmount) {
        super(baseAmount);
    }

    @Override
    public BigDecimal entry(BigDecimal amount) {
        return this.value.add(amount);
    }
}