package com.bitspilani.restaurant.repository;

import com.bitspilani.restaurant.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
