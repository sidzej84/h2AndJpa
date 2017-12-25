package controller;

import model.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.TransactionService;

import java.util.Hashtable;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService ps;

    @RequestMapping(method = RequestMethod.GET)
    public Hashtable<Integer, TransactionDetails> getAll() {
        return ps.getAll();
    }

    @RequestMapping("/{id}")
    public TransactionDetails getTransactions(@PathVariable("id") Integer id) {
        return ps.getTransaction(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public TransactionDetails deleteTransaction (@PathVariable("id") Integer id) {
        TransactionDetails transaction = ps.getTransaction(id);
        ps.deleteTransactionById(id);
        return null;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTransaction(@PathVariable("id") Integer id, @RequestBody TransactionDetails transaction) {


        transaction.setId(id);
        ps.updateTransaction(transaction);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDetails transaction, UriComponentsBuilder ucBuilder) {

        ps.saveTransaction(transaction);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(transaction.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


}
