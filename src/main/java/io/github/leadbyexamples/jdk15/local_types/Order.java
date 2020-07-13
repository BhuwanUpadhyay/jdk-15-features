package io.github.leadbyexamples.jdk15.local_types;

public class Order {
    private final String item;
    private final Integer quantity;

    public Order(String item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getItem() {
        return item;
    }
}
