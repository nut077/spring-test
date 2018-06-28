package com.nutfreedom.springtest.controller;

import com.nutfreedom.springtest.business.ItemBusinessService;
import com.nutfreedom.springtest.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Fruit", 50, 2);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return itemBusinessService.retreiveHardcodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems() {
        return itemBusinessService.retrieveAllItem();
    }

    @PostMapping("/item")
    public ResponseEntity<URI> createItem(@RequestBody Item item) {
        try {
            itemBusinessService.createItem(item);
            int id = item.getId();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
