package com.tw.inventorymanagement;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service

public class InventoryService {
    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public ItemDTO getItems(){
        Set<Item> allItems = inventoryRepository.getItem();
        return new ItemDTO(allItems,totalPrice(allItems));
    }

    public Item addItem(Item item) {
        inventoryRepository.addItem(item);
        return item;
    }

    public boolean deleteItemById(int id) {
        inventoryRepository.deleteItem(id);
        return false;
    }

    public double totalPrice(Set<Item> items) {
        double totalPrice=0;
        for(Item item:items){
            totalPrice=totalPrice+ item.getPrice();
        }
        return totalPrice;
    }
}
