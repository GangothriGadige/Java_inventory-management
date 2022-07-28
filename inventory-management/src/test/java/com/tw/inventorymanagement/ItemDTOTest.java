package com.tw.inventorymanagement;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.tags.form.SelectTag;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ItemDTOTest {
    @Test
    void shouldBeAbleToCalculateTotalPrice(){
        ItemDTO itemDTO = new ItemDTO(Set.of(new Item("book", UUID.randomUUID(),100),
              new Item("pen",UUID.randomUUID(),10)));
        double result = itemDTO.getTotalPrice();
        assertEquals(110,result);
    }

}