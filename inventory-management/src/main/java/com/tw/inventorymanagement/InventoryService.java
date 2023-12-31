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

    public ReqItemDTO getItems(){
        Set<Item> allItems = inventoryRepository.getItem();
        return new ReqItemDTO(allItems,totalPrice(allItems));
    }

    public UUID addItem(CreateItemDTO itemDTO)throws IllegalArgumentException{
        Set<Item> items = inventoryRepository.getItem();
        for(Item item :items){
            if(item.getItemName().equals(itemDTO.getItemName())){
                throw new IllegalArgumentException("Name already exists");
            }
        }
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
