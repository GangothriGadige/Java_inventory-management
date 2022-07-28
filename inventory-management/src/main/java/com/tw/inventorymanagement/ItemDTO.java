package com.tw.inventorymanagement;

import java.util.Objects;
import java.util.Set;

public class ItemDTO {
    private Set<Item> items;
    private double totalPrice;
    public ItemDTO(){

    }

    public ItemDTO(Set<Item> items, double totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }
    public ItemDTO(Set<Item> items){
        this.items=items;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return Double.compare(itemDTO.totalPrice, totalPrice) == 0 && Objects.equals(items, itemDTO.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, totalPrice);
    }
}

