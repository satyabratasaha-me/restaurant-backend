package com.bitspilani.restaurant.controller;

import com.bitspilani.restaurant.models.OrderStatus;
import com.bitspilani.restaurant.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-status")
public class OrderStatusController {

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @GetMapping("/all")
    public List<OrderStatus> getAllStatus(){
        List<OrderStatus> orderStatuses = orderStatusRepository.findAll();
        return orderStatuses;
    }
}
