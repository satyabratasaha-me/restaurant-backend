package com.bitspilani.restaurant.repository;

import com.bitspilani.restaurant.models.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItems,Integer>{
}
