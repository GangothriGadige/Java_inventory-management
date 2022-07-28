package com.tw.inventorymanagement;

import java.util.Objects;

public class CreateItemDTO {
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String itemName;
    private  double price;

    public CreateItemDTO(String itemName, double price) {
        this.itemName = itemName;
        this.price =price;
    }


    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateItemDTO that = (CreateItemDTO) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, price);
    }
}
