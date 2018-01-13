package controller;

import model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.VehicleServiceInterface;
import java.util.Hashtable;


@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleServiceInterface ps;

    @RequestMapping(method = RequestMethod.GET)
    public Vehicle getAll() {
        return ps.getAll();
    }

    @RequestMapping("/{id}")
    public Vehicle getTransactions(@PathVariable("id") Long id) {
        return ps.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Vehicle deleteTransaction(@PathVariable("id") Long id) {
        Vehicle transaction = ps.get(id);
        ps.delete(id);
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTransaction(@PathVariable("id") Long id, @RequestBody Vehicle transaction) {

        transaction.setId(id);
        ps.update(transaction);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createTransaction(@RequestBody Vehicle transaction, UriComponentsBuilder ucBuilder) {

        ps.add(transaction);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(transaction.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


}
