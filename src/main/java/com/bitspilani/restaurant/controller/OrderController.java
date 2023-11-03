package com.bitspilani.restaurant.controller;

import com.bitspilani.restaurant.models.CustomerOrder;
import com.bitspilani.restaurant.models.MenuItems;
import com.bitspilani.restaurant.models.Orders;
import com.bitspilani.restaurant.repository.CustomerOrderRepository;
import com.bitspilani.restaurant.repository.MenuItemRepository;
import com.bitspilani.restaurant.repository.OrderRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Stream;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MenuItemRepository menuItemRepository;

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    @GetMapping("/get-all-orders")
    public List<Orders> getAllOrders(){
        return orderRepository.findAll();
    }

    @PostMapping("/create-order/{customerId}")
    public ResponseEntity<?> createOrderByCustomerID(@PathVariable String customerId, @RequestBody List<Map<String,String>> items){
        CustomerOrder customerOrder = new CustomerOrder(Integer.parseInt(customerId),1);
        int orderId = customerOrderRepository.save(customerOrder).getOrderId();
        List<Orders> orderList = new ArrayList<Orders>();
        for(Map<String,String> item: items){
            Orders orders = new Orders(orderId,Integer.parseInt(item.get("menuItemId")),Integer.parseInt((item.get("quantity"))));
            orderList.add(orders);
        }
        orderRepository.saveAll(orderList);
        return new ResponseEntity<>(orderList, HttpStatus.CREATED);
    }

    @PutMapping("/update-status/{orderId}")
    public ResponseEntity<?> generateInvoice(@PathVariable Integer orderId, @RequestBody Map<String,Integer> body){
        CustomerOrder customerOrder = customerOrderRepository.findById(orderId).get();
        customerOrder.setStatusId(body.get("status"));
        customerOrderRepository.save(customerOrder);
        return new ResponseEntity<>(customerOrder,HttpStatus.OK);
    }




}
