package com.tw.inventorymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class InventoryController {
    @Autowired
    InventoryService inventoryService;
    private Item items;

    @PostMapping("/inventory/items/")
    public ResponseEntity<?> create(@RequestBody CreateItemDTO item) {
        if(item.getItemName()==null || "".equals(item.getItemName())){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(new ErrorDTO("Name is mandatory"));
        }
        UUID response =inventoryService.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResItemDTO(response));
    }

    @DeleteMapping("/inventory/items/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        boolean response = inventoryService.deleteItemById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @GetMapping("/inventory/items/")
    public ReqItemDTO getItems() {
        return inventoryService.getItems();
    }

}
