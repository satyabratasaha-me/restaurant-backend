package com.bitspilani.restaurant.controller;

import com.bitspilani.restaurant.models.Customer;
import com.bitspilani.restaurant.models.ErrorMessage;
import com.bitspilani.restaurant.models.MenuItems;
import com.bitspilani.restaurant.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/menu-items")
public class MenuItemsController {

    @Autowired
    MenuItemRepository menuItemRepository;

    @GetMapping("/get-all-items")
    public List<MenuItems> getAllMenuItems(){
        return menuItemRepository.findAll();
    }

    @PostMapping("/create-menu-item")
    public ResponseEntity<?> createMenuItem(@RequestBody Map<String,String> body){
        String name = body.get("name");
        String category = body.get("category");
        Integer price = Integer.parseInt(body.get("price"));
        String imageLink = body.get("imageLink");

        MenuItems menuItem = new MenuItems(name,category,price,imageLink);
        try {
            menuItemRepository.save(menuItem);
        }
        catch(Exception ex){
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setMessage(ex.getMessage());
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(menuItem,HttpStatus.CREATED);
    }

    @PutMapping("/update-price/{id}")
    public ResponseEntity<?> updatePrice(@PathVariable("id") Integer menuId, @RequestBody Map<String,String> body){
        Integer price = Integer.parseInt(body.get("price"));
        MenuItems menuItem = menuItemRepository.findById(menuId).get();
        menuItem.setPrice(price);
        try {
            menuItemRepository.save(menuItem);
        }
        catch(DataIntegrityViolationException ex){
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setMessage(ex.getMessage());
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(menuItem,HttpStatus.ACCEPTED);

    }






}
