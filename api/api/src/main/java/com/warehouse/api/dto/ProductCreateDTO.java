package com.warehouse.api.dto;

public class ProductCreateDTO {

    private String nome;
    private String sku;

    public ProductCreateDTO(){
    }

    public ProductCreateDTO(String nome, String sku) {
        this.nome = nome;
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
