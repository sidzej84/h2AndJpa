package controller;

import model.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
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





}
