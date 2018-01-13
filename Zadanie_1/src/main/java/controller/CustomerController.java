package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.CustomerServiceInterface;


import java.util.Hashtable;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerServiceInterface ps;

    @RequestMapping(method = RequestMethod.GET)
    public Customer getAll() {
        return ps.getAll();
    }

    @RequestMapping("/{id}")
    public Customer getTransactions(@PathVariable("id") Long id) {
        return ps.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Customer deleteTransaction(@PathVariable("id") Long id) {
        Customer transaction = ps.get(id);
        ps.delete(id);
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTransaction(@PathVariable("id") Long id, @RequestBody Customer transaction) {

        transaction.setId(id);
        ps.update(transaction);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createTransaction(@RequestBody Customer transaction, UriComponentsBuilder ucBuilder) {

        ps.add(transaction);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(transaction.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


}
