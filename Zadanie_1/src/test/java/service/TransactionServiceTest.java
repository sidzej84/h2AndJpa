package service;

import model.TransactionDetails;
import org.junit.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.*;


public class TransactionServiceTest {
    public static final String serviceUri = "http://localhost:8080/transactions";

    @Test
    public void getTransactionShouldReturn200HttpCode() {
        System.out.println("+++++++getTransaction TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transaction = restTemplate.getForObject(serviceUri+"/1",TransactionDetails.class);
        System.out.println(transaction);
    }

    @Test
    public void getAllShouldReturn200HttpCode() {
        System.out.println("+++++++getAll TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(serviceUri+"/", TransactionDetails.class);
    }

    @Test
    public void deleteTransactionByIdShouldReturn200HttpCode() {
        System.out.println("+++++++deleteTransactionById TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(serviceUri+"/0");
    }

    @Test
    public void updateTransactionShouldReturn200HttpCode() {
        System.out.println("+++++++updateTransaction TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transaction = new TransactionDetails();
        transaction.setCustomerFirstName("Czesław");
        transaction.setCustomerLastName("Niemen");
        restTemplate.put(serviceUri+"/1", transaction);
    }

    @Test
    public void saveTransactionShouldReturn201HttpCode() {
        System.out.println("+++++++saveTransaction TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transaction = new TransactionDetails();
        transaction.setCustomerFirstName("Jan Stefan");
        transaction.setCustomerLastName("Żeromski");
        restTemplate.postForLocation(serviceUri+"/", transaction, TransactionDetails.class);
    }
    @Test (expected = HttpClientErrorException.class)
    public void transactionControllerShouldThrowNotFoundException() {
        System.out.println("+++++++transactionNotFoundException TEST++++++");
        RestTemplate restTemplate = new RestTemplate();
        TransactionDetails transaction = restTemplate.getForObject(serviceUri+"/22",TransactionDetails.class);
        assertThat(transaction.getId()).isEqualTo(22);
    }
}