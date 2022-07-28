package com.tw.inventorymanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;
import java.util.UUID;

import static java.util.Collections.emptySet;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InventoryController.class)
public class InventoryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    InventoryService inventoryService;
    Item item1 = new Item("Laptop", 40000);
    Item items;

    @Test
    void shouldAddAnItemToTheInventory() throws Exception {
        CreateItemDTO item = new CreateItemDTO("soap",10);
        UUID id = UUID.randomUUID();
        when(inventoryService.addItem(item)).thenReturn(true);

        mockMvc.perform(post("/inventory/items/")
                        .content(objectMapper.writeValueAsString(item))
                        .header("Content-Type", "application/json"))
                .andExpect(status().isCreated());
                //.andExpect(content().string(objectMapper.writeValueAsString(item)));

        verify(inventoryService).addItem(item);

    }

    @Test
    void shouldDeleteAnItemFromTheInventory() throws Exception {
        UUID idToDelete =UUID.randomUUID();
        when(inventoryService.deleteItemById(idToDelete)).thenReturn(false);

        mockMvc.perform(delete("/inventory/items/"+idToDelete))
                .andExpect(status().isNoContent())
                .andExpect(content().string("false"));

        verify(inventoryService).deleteItemById(idToDelete);
    }

    @Test
    void shouldGetItemsInTheInventory() throws Exception {
        ItemDTO expected = new ItemDTO();
        Set<Item> expectedItems = Set.of(new Item("soap",10),
                new Item("shoe",50));

        expected.setItems(expectedItems);
        when(inventoryService.getItems()).thenReturn(expected);

        mockMvc.perform(get("/inventory/items/"))
                .andExpect(content().string(objectMapper.writeValueAsString(expected)))
                .andExpect(status().isOk());

        verify(inventoryService).getItems();
    }


}
