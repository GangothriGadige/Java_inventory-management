package com.tw.inventorymanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

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
    Item item = new Item("Laptop", 1,40000);
    Item items;

    @Test
    void shouldAddAnItemToTheInventory() throws Exception {
        when(inventoryService.addItem(item)).thenReturn(item);

        mockMvc.perform(post("/inventory/items/")
                        .content(objectMapper.writeValueAsString(item))
                        .header("Content-Type", "application/json"))
                .andExpect(status().isCreated())
                .andExpect(content().string(objectMapper.writeValueAsString(item)));

        verify(inventoryService).addItem(item);

    }

    @Test
    void shouldDeleteAnItemFromTheInventory() throws Exception {
        when(inventoryService.deleteItemById(1)).thenReturn(true);

        mockMvc.perform(delete("/inventory/items/1/"))
                .andExpect(status().isNoContent())
                .andExpect(content().string("true"));

        verify(inventoryService).deleteItemById(1);
    }

    @Test
    void shouldGetItemsInTheInventory() throws Exception {
        ItemDTO expected = new ItemDTO();
        Set<Item> expectedItems = Set.of(new Item("soap",1,10),
                new Item("shoe",2,50));

        expected.setItems(expectedItems);
        when(inventoryService.getItems()).thenReturn(expected);

        mockMvc.perform(get("/inventory/items/"))
                .andExpect(content().string(objectMapper.writeValueAsString(expected)))
                .andExpect(status().isOk());

        verify(inventoryService).getItems();
    }


}
