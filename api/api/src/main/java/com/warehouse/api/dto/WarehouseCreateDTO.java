package com.warehouse.api.dto;

public class WarehouseCreateDTO {

    private String name;
    private String description;


    public WarehouseCreateDTO() {
    }

    public WarehouseCreateDTO(String name, String description, AddressCreateDTO address) {
        this.name = name;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
