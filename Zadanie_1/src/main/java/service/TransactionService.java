package service;

import model.TransactionDetails;
import org.springframework.stereotype.Service;
import util.TransactionNotFoundException;
import java.util.Hashtable;

@Service
public class TransactionService {
    Hashtable<Integer, TransactionDetails> transactions = new Hashtable<Integer, TransactionDetails>();
    private int currentId;

    public TransactionService() {
        TransactionDetails Transaction1 = new TransactionDetails();
        Transaction1.setId(currentId);
        Transaction1.setCustomerFirstName("John");
        Transaction1.setCustomerLastName("Doe");
        transactions.put(currentId, Transaction1);
        currentId++;

        TransactionDetails Transaction2 = new TransactionDetails();
        Transaction2.setId(currentId);
        Transaction2.setCustomerFirstName("Peter");
        Transaction2.setCustomerLastName("Saint");
        transactions.put(currentId, Transaction2);
        currentId++;
    }

    public TransactionDetails getTransaction(Integer id) {
        if (transactions.containsKey(id)) {
            return transactions.get(id);
        } else {
            throw new TransactionNotFoundException();
        }
    }

    public Hashtable<Integer, TransactionDetails> getAll() {
        return transactions;
    }


    public void deleteTransactionById(Integer id) {
        if (transactions.containsKey(id)) {
            transactions.remove(id);
        } else {
            throw new TransactionNotFoundException();
        }
    }

    public void updateTransaction(TransactionDetails currentTransaction) {
        int index = currentTransaction.getId();
        if (transactions.containsKey(index)) {
            transactions.put(index, currentTransaction);
        } else {
            throw new TransactionNotFoundException();
        }
    }

    public void saveTransaction(TransactionDetails transaction) {
        transaction.setId(currentId);
        transactions.put(currentId, transaction);
        currentId++;
    }
}
