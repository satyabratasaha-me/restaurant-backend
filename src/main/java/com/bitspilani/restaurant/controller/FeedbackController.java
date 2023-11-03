package com.bitspilani.restaurant.controller;

import com.bitspilani.restaurant.models.CustomerOrder;
import com.bitspilani.restaurant.models.Feedback;
import com.bitspilani.restaurant.repository.CustomerOrderRepository;
import com.bitspilani.restaurant.repository.CustomerRepository;
import com.bitspilani.restaurant.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    @Autowired
    FeedbackRepository feedbackRepository;

    @PostMapping("/feedback-by-order/{orderId}")
    public ResponseEntity<?> createFeedback(@PathVariable String orderId, @RequestBody Map<String,String> body){
        CustomerOrder customerOrder = customerOrderRepository.findById(Integer.parseInt(orderId)).get();
        int customerId = customerOrder.getCustomerId();
        String rating = body.get("rating");
        String comments = body.get("comments");
        Feedback feedback = new Feedback(Integer.parseInt(orderId),customerId,Integer.parseInt(rating),comments);
        feedbackRepository.save(feedback);
        return new ResponseEntity<>(feedback, HttpStatus.CREATED);

    }

    @GetMapping("/get-all")
    public List<Feedback> getAllFeedback(){
        return feedbackRepository.findAll();
    }
}
