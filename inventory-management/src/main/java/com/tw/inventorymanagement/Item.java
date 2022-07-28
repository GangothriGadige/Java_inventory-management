package com.tw.inventorymanagement;

import java.util.Objects;
import java.util.UUID;

public class Item {
    private String itemName;
    private UUID id;
    private double price;

    public Item(String itemName, double price) {
        this.itemName = itemName;
        this.id = id;
        this.price =price;
    }

    public Item(String itemName, UUID id, double price) {
        this.itemName = itemName;
        this.id = id;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 && Objects.equals(itemName, item.itemName) && Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, id, price);
    }
}
