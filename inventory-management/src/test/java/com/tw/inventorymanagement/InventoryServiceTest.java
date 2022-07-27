package com.tw.inventorymanagement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {
    @Mock
    private InventoryRepository repository;

    @InjectMocks
    private InventoryService inventoryService;
    private Item items;


    @Test
    void shouldBeAbleToDeleteAnItemById(){
        when(repository.deleteItem(1)).thenReturn(true);

        inventoryService.deleteItemById(1);

        verify(repository).deleteItem(1);
    }
    @Test
    void shouldAddItem(){
        Item item = new Item("Laptop",1,40000);
        when(repository.addItem(item)).thenReturn(true);

        inventoryService.addItem(item);

        verify(repository).addItem(item);
    }
    @Test
    void shouldGetAllItems(){
        Set<Item> items =Set.of(new Item("soap",1,10),
                new Item("shoe",2,50));
        when(repository.getItem()).thenReturn(items);
        ItemDTO itemDTO =inventoryService.getItems();

        ItemDTO expected =new ItemDTO();
        Set<Item> expectedItems = Set.of(new Item("soap",1,10),
                new Item("shoe",2,50));
        expected.setItems(expectedItems);
        expected.setTotalPrice(60);

        assertEquals(expected,itemDTO);
        verify(repository).getItem();
    }



}

