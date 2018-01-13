package dao;

import model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class CustomerDao {
    public Customer update(Customer customer) {
        return null;
    }

    public Customer get(Long customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);
        return customer;
    }

    public Customer add(Customer customer) {
        return null;
    }

    public Customer delete(Long customerId) {
        return null;
    }

    public Customer getAll(Long customerId) {
        return null;
    }

}
