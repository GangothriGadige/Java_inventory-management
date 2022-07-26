package com.tw.inventorymanagement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Repository;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {
    @Mock
    private InventoryRepository repository;

    @InjectMocks
    private InventoryService inventoryService;
    @Test
    void shouldBeAbleToDeleteAnItemById(){
        when(repository.deleteItem(1)).thenReturn(true);

        inventoryService.deleteItemById(1);

        verify(repository).deleteItem(1);
    }
    @Test
    void shouldAddItem(){
        Item item = new Item("Laptop",1);
        when(repository.addItem(item)).thenReturn(true);

        inventoryService.addItem(item);

        verify(repository).addItem(item);
    }
    @Test
    void shouldGetAllItems(){
        when(repository.getItem()).thenReturn(Collections.emptySet());

        inventoryService.getItem();

        verify(repository).getItem();
    }

}

