package service;

import model.TransactionDetails;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import util.TransactionNotFoundException;

import static org.junit.Assert.*;

public class TransactionServiceTest {
    public static final String serviceUri = "http://localhost:8080/transactions";

    @Test
    public void getTransaction() {
        System.out.println("+++++++getTransaction TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transaction = restTemplate.getForObject(serviceUri+"/1",TransactionDetails.class);
        System.out.println(transaction);
    }

    @Test
    public void getAll() {
        System.out.println("+++++++getAll TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(serviceUri+"/", TransactionDetails.class);
    }

    @Test
    public void deleteTransactionById() {
        System.out.println("+++++++deleteTransactionById TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(serviceUri+"/0");
    }

    @Test
    public void updateTransaction() {
        System.out.println("+++++++updateTransaction TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transaction = new TransactionDetails();
        transaction.setCustomerFirstName("Czesław");
        transaction.setCustomerLastName("Niemen");
        restTemplate.put(serviceUri+"/1", transaction);
    }

    @Test
    public void saveTransaction() {
        System.out.println("+++++++saveTransaction TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transaction = new TransactionDetails();
        transaction.setCustomerFirstName("Jan Stefan");
        transaction.setCustomerLastName("Żeromski");
        restTemplate.postForLocation(serviceUri+"/", transaction, TransactionDetails.class);
    }
    @Test (expected = TransactionNotFoundException.class)
    public void testTransactionNotFoundException() {
        System.out.println("+++++++transactionNotFoundException TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transaction = new TransactionDetails();
        transaction.setCustomerFirstName("Czesław");
        transaction.setCustomerLastName("Niemen");
        restTemplate.put(serviceUri+"/22", transaction);
    }
}