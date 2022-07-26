package com.tw.inventorymanagement;

import java.util.Collections;
import java.util.Set;

public class InventoryService {
    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    Set<Item> getItem(){
        inventoryRepository.getItem();
        return Collections.emptySet();
    }

    public Item addItem(Item item) {
        inventoryRepository.addItem(item);
        return item;
    }
    public boolean deleteItemById(int id) {
        inventoryRepository.deleteItem(id);
        return false;

    }
}
