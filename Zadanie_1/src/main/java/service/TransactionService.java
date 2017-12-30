package service;

import model.TransactionDetails;
import org.springframework.stereotype.Service;
import util.TransactionNotFoundException;

import java.util.Hashtable;

@Service
public class TransactionService {
    Hashtable<Integer, TransactionDetails> transactions = new Hashtable<Integer, TransactionDetails>();
    int currentId = 0;
    public TransactionService() {
        TransactionDetails Transaction1 = new TransactionDetails();
        Transaction1.setId(currentId);
        Transaction1.setCustomerFirstName("Piotr");
        Transaction1.setCustomerLastName("Kowalski");
        transactions.put(currentId, Transaction1);
        currentId ++;

        TransactionDetails Transaction2 = new TransactionDetails();
        Transaction2.setId(currentId);
        Transaction2.setCustomerFirstName("Janina");
        Transaction2.setCustomerLastName("Jakim");
        transactions.put(currentId, Transaction2);
        currentId ++;


    }

    public TransactionDetails getTransaction(Integer id) {
        if (transactions.containsKey(id)) {
            return transactions.get(id);
        }
        else {
            throw new TransactionNotFoundException();

        }
    }

    public Hashtable<Integer, TransactionDetails> getAll() {
        return transactions;
    }


    public void deleteTransactionById(Integer id) {
        if (transactions.containsKey(id)) {
        transactions.remove(id);
        }
        else {
            throw new TransactionNotFoundException();
        }

    }


    public TransactionDetails updateTransaction(TransactionDetails currentTransaction) {
        Integer index = currentTransaction.getId();
        if (transactions.containsKey(index)) {
            transactions.put(index, currentTransaction);
            return transactions.get(index);
        }
        else {
            throw new TransactionNotFoundException();
        }
    }

    public void saveTransaction(TransactionDetails transaction) {

        transaction.setId(currentId);
        transactions.put(currentId, transaction);
        currentId ++;



    }
}
