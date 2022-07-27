package com.tw.inventorymanagement;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository
public class InventoryRepository {
    Set<Item> items = new HashSet<>();
    int totalPrice;

    public boolean deleteItem(int id) {
        for(Item item:items){
            if(item.getId()==id){
                items.remove(item);
            }
        }
        return true;
    }

    public boolean addItem(Item item) {
        items.add(item);
        return true;
    }

    public Set<Item> getItem() {
        return items;
    }


}
