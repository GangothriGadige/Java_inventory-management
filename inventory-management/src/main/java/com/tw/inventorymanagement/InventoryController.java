package com.tw.inventorymanagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class InventoryController {
    private Set<String> inventory = new HashSet<>();

    @PostMapping("/")
    public ResponseEntity addItem(@RequestBody String itemName) {
        inventory.add(itemName);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
