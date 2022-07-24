package com.tw.inventorymanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InventoryController.class)
public class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldAddAnItemToTheInventory() throws Exception {
        mockMvc.perform(post("/")
                        .content("Laptop"))
                .andExpect(status().isCreated());

    }
   @Test
    void shouldDeleteAnItemFromTheInventory() throws Exception {
        mockMvc.perform(delete("/")
               .content("Laptop"))
               .andExpect(status().isNoContent());
    }
}
