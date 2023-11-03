package com.bitspilani.restaurant.controller;

import com.bitspilani.restaurant.models.Customer;
import com.bitspilani.restaurant.models.ErrorMessage;
import com.bitspilani.restaurant.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/get-all-customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping("/create-customer")
    public ResponseEntity<?> createCustomer(@RequestBody Map<String, String> body){
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        String emailId = body.get("emailId");
        String primaryPhoneNumber = body.get("primaryPhoneNumber");
        Customer customer = new Customer(firstName,lastName,emailId,primaryPhoneNumber);
        try {
            customerRepository.save(customer);
        }
        catch(DataIntegrityViolationException ex){
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setMessage(ex.getMessage());
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("/update-primary-contact/{id}")
    public ResponseEntity<?> updatePrimaryContact(@PathVariable("id") Integer customerId, @RequestBody Map<String,String> body){
        String primaryPhoneNumber = body.get("primaryPhoneNumber");
        Customer customer = customerRepository.findById(customerId).get();
        customer.setPrimaryPhoneNumber(primaryPhoneNumber);
        try {
            customerRepository.save(customer);
        }
        catch(DataIntegrityViolationException ex){
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setMessage(ex.getMessage());
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);

    }

    @GetMapping("/find-customer-by-phone/{phoneNumber}")
    public ResponseEntity<?>  getCustomerFindByPhoneNumber(@PathVariable String phoneNumber){
        Customer customer = customerRepository.findByPhoneNumber(phoneNumber);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }




}
