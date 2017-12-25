package controller;

import model.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TransactionService;

import java.util.Hashtable;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService ps;

    @RequestMapping("/all")
    public Hashtable<String, TransactionDetails> getAll() {
        return ps.getAll();
    }

    @RequestMapping("{id}")
    public TransactionDetails getTransactions(@PathVariable("id") String id) {
        return ps.getTransaction(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public TransactionDetails deleteTransaction (@PathVariable("id") String id) {
        TransactionDetails transaction = ps.getTransaction(id);
        ps.deleteTransactionById(id);
        return null;

    }

    // ------------------- Update a User ------------------------------------------------

    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTransaction(@PathVariable("id") String id, @RequestBody TransactionDetails transaction) {

        TransactionDetails currentTransaction = TransactionService.findById(id);



        currentTransaction.setCustomerFirstName(transaction.getCustomerFirstName());
        currentTransaction.setCustomerLastName(transaction.getCustomerLastName());
        currentTransaction.setCustomerBirthDate(transaction.getCustomerBirthDate());

        TransactionService.updateTransaction(currentTransaction);
        return new ResponseEntity<TransactionDetails>(currentTransaction, HttpStatus.OK);
    }





}
