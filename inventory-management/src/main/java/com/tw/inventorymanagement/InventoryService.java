package com.tw.inventorymanagement;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service

public class InventoryService {
    private InventoryRepository inventoryRepository;
    private IdGenerator idGenerator;

    public InventoryService(InventoryRepository inventoryRepository, IdGenerator idGenerator) {
        this.inventoryRepository = inventoryRepository;
        this.idGenerator =idGenerator;
    }

    public ItemDTO getItems(){
        Set<Item> allItems = inventoryRepository.getItem();
        return new ItemDTO(allItems,totalPrice(allItems));
    }

    public boolean addItem(CreateItemDTO itemDTO) {
        UUID id = idGenerator.generate();
        Item item =new Item(itemDTO.getItemName(),id,itemDTO.getPrice());
        return inventoryRepository.addItem(item);
    }

    public boolean deleteItemById(UUID id) {
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
