package com.bitspilani.restaurant.repository;

import com.bitspilani.restaurant.models.MenuItems;
import com.bitspilani.restaurant.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,Integer> {
}
