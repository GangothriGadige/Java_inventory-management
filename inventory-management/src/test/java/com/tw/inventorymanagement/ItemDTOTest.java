package com.tw.inventorymanagement;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ItemDTOTest {
    @Test
    void shouldBeAbleToCalculateTotalPrice(){
        ReqItemDTO itemDTO = new ReqItemDTO(Set.of(new Item("book", UUID.randomUUID(),100),
              new Item("pen",UUID.randomUUID(),10)));
        double result = itemDTO.getTotalPrice();
        assertEquals(110,result);
    }

}