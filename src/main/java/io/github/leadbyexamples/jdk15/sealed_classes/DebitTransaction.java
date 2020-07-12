package io.github.leadbyexamples.jdk15.sealed_classes;

import java.math.BigDecimal;

final class DebitTransaction extends Transaction {

    public DebitTransaction(BigDecimal baseAmount) {
        super(baseAmount);
    }

    @Override
    public BigDecimal entry(BigDecimal amount) {
        return this.value.subtract(amount);
    }
}
