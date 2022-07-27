package com.tw.inventorymanagement;

import java.util.Objects;

public class Item {
    private final String itemName;
    private final int id;
    private final int price;

    public Item(String itemName, int id, int price) {
        this.itemName = itemName;
        this.id = id;
        this.price =price;
    }

    public double getPrice() {
        return price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Objects.equals(itemName, item.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, id);
    }
}
