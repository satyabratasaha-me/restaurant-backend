package com.bitspilani.restaurant.controller;

import com.bitspilani.restaurant.models.ErrorMessage;
import com.bitspilani.restaurant.models.Invoice;
import com.bitspilani.restaurant.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceRepository invoiceRepository;

    @GetMapping("/get-invoice-by-order-id/{orderId}")
    public ResponseEntity<?> getInvoiceByOderId(@PathVariable String orderId){
        try{
            Invoice invoice = invoiceRepository.findById(Integer.parseInt(orderId)).get();
            return new ResponseEntity<>(invoice, HttpStatus.FOUND);
        }
        catch (NoSuchElementException ex)
        {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setMessage("No order found");
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/updateInvoiceStatusToPaid/{orderId}")
    public ResponseEntity<?> updateInvoiceStatusToPaid(@PathVariable String orderId){
            Invoice invoice = invoiceRepository.findById(Integer.parseInt(orderId)).get();
            invoice.setStatus("PAID");
            invoiceRepository.save(invoice);
            return new ResponseEntity<>(invoice, HttpStatus.OK);
    }
}
