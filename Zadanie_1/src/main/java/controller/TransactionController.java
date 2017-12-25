package controller;

import model.TransactionDetails;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.TransactionService;

import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    public static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
    @Autowired
    TransactionService ps;

    @RequestMapping("/all")
    public Hashtable<String, TransactionDetails> getAll(){
        return ps.getAll();
    }

    @RequestMapping("{id}")
    public TransactionDetails getTransactions(@PathVariable("id") String id){
        return ps.getTransaction(id);
    }

    // -------------------Create a User-------------------------------------------

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        logger.info("Creating User : {}", user);

        if (userService.isUserExist(user)) {
            logger.error("Unable to create. A User with name {} already exist", user.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " +
                    user.getName() + " already exist."), HttpStatus.CONFLICT);
        }
        userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }




}
