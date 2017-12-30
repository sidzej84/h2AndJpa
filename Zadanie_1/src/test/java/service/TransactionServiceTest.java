package service;

import controller.TransactionController;
import model.TransactionDetails;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Hashtable;

import static org.assertj.core.api.Assertions.*;


@ContextConfiguration(locations = {"classpath:/application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)


public class TransactionServiceTest {
    public static final String serviceUri = "http://localhost:8080/transactions";

    @Mock
    private TransactionService transactions;

    @InjectMocks
    RestTemplate restTemplate;
    @Autowired
    private TransactionController transactionController;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTransactionShouldReturn200HttpCode() {
        System.out.println("+++++++getTransaction TEST++++++");

        TransactionDetails transaction = restTemplate.getForObject(serviceUri+"/1",TransactionDetails.class);
        System.out.println(transaction);
    }

    @Test
    public void getAllShouldReturn200HttpCode() {
        System.out.println("+++++++getAll TEST++++++");
        restTemplate.getForObject(serviceUri+"/", TransactionDetails.class);
    }

    @Test
    public void deleteTransactionByIdShouldReturn200HttpCode() {
        System.out.println("+++++++deleteTransactionById TEST++++++");
        restTemplate.delete(serviceUri+"/0");
    }

    @Test
    public void updateTransactionShouldReturn200HttpCode() {
        System.out.println("+++++++updateTransaction TEST++++++");
        TransactionDetails transaction = new TransactionDetails();
        transaction.setCustomerFirstName("Czesław");
        transaction.setCustomerLastName("Niemen");
        restTemplate.put(serviceUri+"/1", transaction);
    }

    @Test
    public void saveTransactionShouldReturn201HttpCode() {
        System.out.println("+++++++saveTransaction TEST++++++");
        TransactionDetails transaction = new TransactionDetails();
        transaction.setCustomerFirstName("Jan Stefan");
        transaction.setCustomerLastName("Żeromski");
        restTemplate.postForLocation(serviceUri+"/", transaction, TransactionDetails.class);
    }
    @Test (expected = HttpClientErrorException.class)
    public void transactionControllerShouldThrowNotFoundException() {
        System.out.println("+++++++transactionNotFoundException TEST++++++");

        TransactionDetails transaction = restTemplate.getForObject(serviceUri+"/22",TransactionDetails.class);
        assertThat(transaction.getId()).isEqualTo(22);
    }
}