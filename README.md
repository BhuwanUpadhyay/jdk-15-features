# Highlight of Jdk 15 Features

![Highlight of Jdk 15 Features](Highlight%20of%20JDK%2015%20Features.png)

Highlighting new features in Java 15 are sealed types, local types.

### Sealed Types

Example of sealed classes:

```java
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

final class CreditTransaction extends Transaction {

    public CreditTransaction(BigDecimal baseAmount) {
        super(baseAmount);
    }

    @Override
    public BigDecimal entry(BigDecimal amount) {
        return this.value.add(amount);
    }
}

final class DebitTransaction extends Transaction {

    public DebitTransaction(BigDecimal baseAmount) {
        super(baseAmount);
    }

    @Override
    public BigDecimal entry(BigDecimal amount) {
        return this.value.subtract(amount);
    }
}

```

Example of sealed interfaces:

```java
sealed interface Shape permits Circle, Rectangle {

    long area();
}

final class Circle implements Shape {

    private final int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public long area() {
        return Math.round(3.14 * radius * radius);
    }

}

non-sealed class Rectangle implements Shape {

    private final int length;
    private final int width;

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public long area() {
        return length * width;
    }

}

final class Square extends Rectangle {

    Square(int side) {
        super(side, side);
    }

}
```

### Local Types

Example of local record:

```java
    public List<Customer> filterForGoldCustomer(List<Customer> customers) {

        record GoldCustomer(Customer customer, List<Order> orders) {

            boolean hasEnoughOrders() {
                boolean hasMoreThanOrEqualToTwo = GoldCustomer.this.orders.size() >= 2;
                Integer totalQuantity = GoldCustomer.this.orders.stream().map(Order::getQuantity).reduce(0, Integer::sum);
                return hasMoreThanOrEqualToTwo && totalQuantity > 100;
            }

        }

        return customers.stream()
                .map(customer -> new GoldCustomer(customer, customer.getOrders()))
                .filter(GoldCustomer::hasEnoughOrders)
                .map(GoldCustomer::customer)
                .collect(Collectors.toList());

    }
```

Example of local enums:

```java
    public List<Customer> filterActiveOrVipCustomer(List<Customer> customers) {

        enum Status {
            Active, Inactive, Suspended, Vip;

            public static boolean isActiveOrVip(String status) {
                return Objects.equals(status, Active.name()) || Objects.equals(status, Vip.name());
            }
        }

        return customers.stream()
                .filter(customer -> Status.isActiveOrVip(customer.getStatus()))
                .collect(Collectors.toList());
    }
```

Example of local interfaces:

```java
    public List<Customer> filterInactiveCustomer(List<Customer> customers) {

        interface InactiveCollector {
            List<Customer> inactive(List<Customer> customers);
        }

        class CustomerInactiveCollector implements InactiveCollector {

            @Override
            public List<Customer> inactive(List<Customer> customers) {
                return customers.stream().filter(customer -> Objects.equals(customer.getStatus(), "Inactive")).collect(Collectors.toList());
            }
        }

        InactiveCollector inactiveCollector = new CustomerInactiveCollector();

        return inactiveCollector.inactive(customers);


    }
```

## That’s all folks.
Thanks for reading! Code example on [Github](https://github.com/lead-by-examples/jdk-15-features).

## References
- https://openjdk.java.net/projects/jdk/15/
