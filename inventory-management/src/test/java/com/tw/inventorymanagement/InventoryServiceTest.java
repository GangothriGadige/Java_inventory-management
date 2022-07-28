package com.tw.inventorymanagement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {
    @Mock
    private InventoryRepository repository;

    @Mock
    private IdGenerator idGenerator;
    @InjectMocks
    private InventoryService inventoryService;

    @Test
    void shouldBeAbleToDeleteAnItemById(){
        UUID idToDelete =UUID.randomUUID();
        when(repository.deleteItem(idToDelete)).thenReturn(true);

        inventoryService.deleteItemById(idToDelete);

        verify(repository).deleteItem(idToDelete);
    }
    @Test
    void shouldAddItem(){
        CreateItemDTO item = new CreateItemDTO("soap",10);
        UUID id = UUID.randomUUID();
        when(idGenerator.generate()).thenReturn(id);

        inventoryService.addItem(item);

        Item itemSoap = new Item("soap",id,10);
        verify(repository).addItem(itemSoap);
    }
    @Test
    void shouldGetAllItems(){
        Set<Item> items =Set.of(new Item("soap",10),
                new Item("shoe",50));
        when(repository.getItem()).thenReturn(items);
        ItemDTO itemDTO =inventoryService.getItems();

        ItemDTO expected =new ItemDTO();
        Set<Item> expectedItems = Set.of(new Item("soap",10),
                new Item("shoe",50));
        expected.setItems(expectedItems);
        expected.setTotalPrice(60);

        assertEquals(expected,itemDTO);
        verify(repository).getItem();
    }

}

