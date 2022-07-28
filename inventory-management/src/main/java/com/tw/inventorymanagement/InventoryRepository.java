package com.tw.inventorymanagement;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Repository
public class InventoryRepository {
    Set<Item> items = new HashSet<>();

    public boolean deleteItem(UUID id) {
        for(Item item:items){
            if(item.getId()==id){
                items.remove(item);
            }
        }
        return true;
    }

    public boolean addItem(Item item) {
        items.add(item);
        return false;
    }

    public Set<Item> getItem() {
        return items;
    }


}
