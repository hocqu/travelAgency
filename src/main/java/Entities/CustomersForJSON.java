package Entities;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class CustomersForJSON {
    @Expose(serialize = true)
    List<Customer> customers = new ArrayList<>();

    public CustomersForJSON(List<Customer> customers) {
        this.customers.addAll(customers);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
