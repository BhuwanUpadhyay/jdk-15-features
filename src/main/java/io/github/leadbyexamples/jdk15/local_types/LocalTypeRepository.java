package io.github.leadbyexamples.jdk15.local_types;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LocalTypeRepository {

    //local record

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

    // local enums

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

    // local interfaces

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
}
