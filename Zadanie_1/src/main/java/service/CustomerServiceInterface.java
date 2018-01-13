package service;

import dao.CustomerDao;
import model.Customer;

public interface CustomerServiceInterface {
    Customer update(Customer customer);

    Customer get(Long id);

    Customer getAll();

    Customer add(Customer customer);

    Customer delete(Long id);
}
