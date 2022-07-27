package com.tw.inventorymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {
    @Autowired
    InventoryService inventoryService;
    private Item items;

    @PostMapping("/inventory/items/")
    public ResponseEntity<?> create(@RequestBody Item item) {
        Item response = inventoryService.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/inventory/items/{id}/")
    public ResponseEntity<?> delete(@PathVariable int id) {
        boolean response = inventoryService.deleteItemById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @GetMapping("/inventory/items/")
    public ItemDTO getItems() {
        return inventoryService.getItems();
    }

}
