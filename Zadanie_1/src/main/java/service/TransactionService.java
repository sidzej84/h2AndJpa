package service;

import model.TransactionDetails;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
public class TransactionService {
    Hashtable<String, TransactionDetails> transactions = new Hashtable<String, TransactionDetails>();
    public TransactionService(){
        TransactionDetails p = new TransactionDetails();
        p.setId("1");
        p.setCustomerFirstName("Piotr");
        p.setCustomerLastName("Kowalski");
        transactions.put("1", p);

        p = new TransactionDetails();
        p.setId("2");
        p.setCustomerFirstName("Janina");
        p.setCustomerLastName("Jakim");
        transactions.put("2", p);


    }
    public TransactionDetails getTransaction(String id){
        if (transactions.containsKey(id))
            return transactions.get(id);
        else
            return null;
    }
    public Hashtable<String, TransactionDetails> getAll(){
        return transactions;
    }
    public NewTransaction(){
        TransactionDetails p = new TransactionDetails();
        String counter = p.getId();
        transactions.put(counter, p);


    }
}
