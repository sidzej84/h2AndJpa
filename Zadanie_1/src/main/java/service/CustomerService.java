package service;

import dao.CustomerDao;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class CustomerService implements CustomerServiceInterface {
    private CustomerDao customerDao;
    @Autowired
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    @Override
    public Customer update(Customer customer){
        Customer fetchedCustomer = customerDao.get(customer.getId());
        if (fetchedCustomer == null) {
            throw new IdNotFoundException();
        }

        return customerDao.update(customer);

    }

    @Override
    public Customer get(Long id) {
        return null;
    }

    @Override
    public Customer getAll() {
        return null;
    }

    @Override
    public Customer add(Customer customer) {
        return customerDao.add(customer);
    }

    @Override
    public Customer delete(Long id) {
        return  customerDao.delete(id);
    }




}

