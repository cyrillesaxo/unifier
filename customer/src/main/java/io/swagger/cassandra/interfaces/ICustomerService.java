package io.swagger.cassandra.interfaces;

import io.swagger.model.Customer;
import io.swagger.model.CustomerView;

/**
 * Created by Cyrille V Eloundou on 07/06/2017.
 */
public interface ICustomerService {
    public void createCustomer(Customer customer);
    public Customer findByCustomerId(final String customer_id);
    public CustomerView findByFaidId(final String faid);
}
