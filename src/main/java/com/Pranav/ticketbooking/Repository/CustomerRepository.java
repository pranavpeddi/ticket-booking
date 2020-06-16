package com.Pranav.ticketbooking.Repository;

import com.Pranav.ticketbooking.Model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

    Customer findByCustomerName(String name);
}
