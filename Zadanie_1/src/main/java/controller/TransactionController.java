package controller;

import model.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.TransactionService;

import java.util.Hashtable;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService ps;

    @RequestMapping("/all")
    public Hashtable<Integer, TransactionDetails> getAll() {
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

    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTransaction(@PathVariable("id") String id, @RequestBody TransactionDetails transaction) {

        TransactionDetails currentTransaction = ps.getTransaction(id);

        currentTransaction.setCustomerFirstName(transaction.getCustomerFirstName());
        currentTransaction.setCustomerLastName(transaction.getCustomerLastName());
        currentTransaction.setCustomerBirthDate(transaction.getCustomerBirthDate());
        currentTransaction.setCustomerGender(transaction.getCustomerGender());
        currentTransaction.setCustomerPESEL(transaction.getCustomerPESEL());
        currentTransaction.setVehicleRegisterNumber(transaction.getVehicleRegisterNumber());
        currentTransaction.setVehicleFirstRegistrationDate(transaction.getVehicleFirstRegistrationDate());
        currentTransaction.setVehicleUserName(transaction.getVehicleUserName());
        currentTransaction.setVehicleUserPESEL(transaction.getVehicleUserPESEL());
        currentTransaction.setVehicleUserAddress(transaction.getVehicleUserAddress());
        currentTransaction.setVehicleOwnerName(transaction.getVehicleOwnerName());
        currentTransaction.setVehicleOwnerPESEL(transaction.getVehicleOwnerPESEL());
        currentTransaction.setVehicleOwnerAddress(transaction.getVehicleOwnerAddress());
        currentTransaction.setVehicleBrand(transaction.getVehicleBrand());
        currentTransaction.setVehicleType(transaction.getVehicleType());
        currentTransaction.setVehicleModel(transaction.getVehicleModel());
        currentTransaction.setVehicleIdentificationNumber(transaction.getVehicleIdentificationNumber());
        currentTransaction.setVehicleMaxTotalMass(transaction.getVehicleMaxTotalMass());
        currentTransaction.setVehiclePermissableMass(transaction.getVehiclePermissableMass());
        currentTransaction.setVehiclePermissableMassGroup(transaction.getVehiclePermissableMassGroup());
        currentTransaction.setVehicleMassOwn(transaction.getVehicleMassOwn());
        currentTransaction.setVehicleRegisterExpiryDate(transaction.getVehicleRegisterExpiryDate());
        currentTransaction.setVehicleRegisterSetUpDate(transaction.getVehicleRegisterSetUpDate());
        currentTransaction.setVehicleCategory(transaction.getVehicleCategory());
        currentTransaction.setVehicleApprovalNumber(transaction.getVehicleApprovalNumber());
        currentTransaction.setVehicleNumberOfAxles(transaction.getVehicleNumberOfAxles());
        currentTransaction.setVehicleTruckTrailerTotalMassWithBreaks(transaction.getVehicleTruckTrailerTotalMassWithBreaks());
        currentTransaction.setVehicleTruckTrailerTotalMassWithoutBreaks(transaction.getVehicleTruckTrailerTotalMassWithoutBreaks());
        currentTransaction.setVehicleEngineCapacity(transaction.getVehicleEngineCapacity());
        currentTransaction.setVehicleEngineMaxNetPower(transaction.getVehicleEngineMaxNetPower());
        currentTransaction.setVehicleFuelType(transaction.getVehicleFuelType());
        currentTransaction.setVehiclePowerToMass(transaction.getVehiclePowerToMass());
        currentTransaction.setVehicleSeats(transaction.getVehicleSeats());
        currentTransaction.setVehicleStandingPlaces(transaction.getVehicleStandingPlaces());

        ps.updateTransaction(currentTransaction);
        return new ResponseEntity<>(currentTransaction, HttpStatus.OK);
    }


    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDetails transaction, UriComponentsBuilder ucBuilder) {

        ps.saveTransaction(transaction);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/transactions/{id}").buildAndExpand(transaction.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


}
