package io.github.leadbyexamples.jdk15.local_enums;

public class Customer {

    private final String name;
    private final CustomerStatus status;

    public Customer(String name, CustomerStatus status) {

        enum CosumerStatus {

        }

        this.name = name;
        this.status = status;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    enum CustomerStatus {

        ACTIVE, INACTIVE
    }
}
