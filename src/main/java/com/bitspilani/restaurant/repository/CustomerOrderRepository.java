package com.bitspilani.restaurant.repository;

import com.bitspilani.restaurant.models.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Integer> {
//    CustomerOrder findByOrderId(String orderId);
}
