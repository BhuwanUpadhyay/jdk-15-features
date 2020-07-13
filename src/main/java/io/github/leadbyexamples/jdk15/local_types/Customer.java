package io.github.leadbyexamples.jdk15.local_types;

import java.util.List;

public class Customer {

    private final String name;

    private final List<Order> orders;
    private final String status;

    public Customer(String name, List<Order> orders, String status) {
        this.name = name;
        this.orders = orders;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getName() {
        return name;
    }
}
