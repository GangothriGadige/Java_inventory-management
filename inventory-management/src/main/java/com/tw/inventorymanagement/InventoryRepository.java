package com.tw.inventorymanagement;

import java.util.Collections;
import java.util.Set;

public class InventoryRepository {

    public boolean deleteItem(int id) {
        return true;
    }

    public boolean addItem(Item item) {
        return true;
    }

    public Set<Item> getItem() {
        return Collections.emptySet();
    }
}
