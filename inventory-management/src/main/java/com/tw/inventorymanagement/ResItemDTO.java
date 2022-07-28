package com.tw.inventorymanagement;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class ResItemDTO {
    UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ResItemDTO(UUID id) {
        this.id = id;
    }
    public ResItemDTO() {
    }
}

