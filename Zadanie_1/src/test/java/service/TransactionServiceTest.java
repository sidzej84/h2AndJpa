package service;

import model.TransactionDetails;
import org.junit.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


public class TransactionServiceTest {
    public static final String serviceUri = "http://localhost:8080/transactions";

    @Test
    public void getTransactionShouldReturn201HttpCode() {
        System.out.println("+++++++getTransaction TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transaction = restTemplate.getForObject(serviceUri + "/1", TransactionDetails.class);
        System.out.println(transaction);
    }

    @Test
    public void getAllShouldReturn200HttpCode() {
        System.out.println("+++++++getAll TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(serviceUri + "/", TransactionDetails.class);
    }

    @Test
    public void deleteTransactionByIdShouldReturn200HttpCode() {
        System.out.println("+++++++deleteTransactionById TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(serviceUri + "/0");
    }

    @Test
    public void updateTransactionShouldReturn200HttpCode() {
        System.out.println("+++++++updateTransaction TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transaction = new TransactionDetails();
        transaction.setCustomerFirstName("Mark");
        transaction.setCustomerLastName("Twain");
        restTemplate.put(serviceUri + "/1", transaction);
    }

    @Test
    public void addTransactionShouldReturn200HttpCode() {
        System.out.println("+++++++saveTransaction TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transaction = new TransactionDetails();
        transaction.setCustomerFirstName("Stephen");
        transaction.setCustomerLastName("Queen");
        restTemplate.postForLocation(serviceUri + "/", transaction, TransactionDetails.class);
    }

    @Test(expected = HttpClientErrorException.class)
    public void transactionNotFoundExceptionHandlingShouldReturn404HttpCode() {
        System.out.println("+++++++transactionNotFoundExceptionHandling TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(serviceUri + "/20");
    }
}