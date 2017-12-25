package service;

import model.TransactionDetails;
import org.springframework.stereotype.Service;
import java.util.Hashtable;

@Service
public class TransactionService {
    Hashtable<Integer, TransactionDetails> transactions = new Hashtable<Integer, TransactionDetails>();
    int currentId = 0;
    public TransactionService() {
        TransactionDetails p = new TransactionDetails();
        p.setId(1);
        p.setCustomerFirstName("Piotr");
        p.setCustomerLastName("Kowalski");
        transactions.put(1, p);
        currentId ++;

        p = new TransactionDetails();
        p.setId(2);
        p.setCustomerFirstName("Janina");
        p.setCustomerLastName("Jakim");
        transactions.put(2, p);
        currentId ++;


    }

    public TransactionDetails getTransaction(Integer id) {
        if (transactions.containsKey(id))
            return transactions.get(id);
        else
            return null;
    }

    public Hashtable<Integer, TransactionDetails> getAll() {
        return transactions;
    }


    public Hashtable<Integer, TransactionDetails> deleteTransactionById(Integer id) {

        transactions.remove(id);
        return null;

    }


    public Hashtable<Integer, TransactionDetails> updateTransaction(TransactionDetails currentTransaction) {
        int index = currentTransaction.getId();
        transactions.put(index, currentTransaction);
        return null;
    }

    public void saveTransaction(TransactionDetails transaction) {

        transaction.setId(currentId);
        transactions.put(currentId, transaction);
        currentId ++;


    }
}
