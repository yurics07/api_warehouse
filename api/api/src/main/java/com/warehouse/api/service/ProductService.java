package com.warehouse.api.service;

import com.warehouse.api.Entity.Product;
import com.warehouse.api.Repository.ProductRepository;
import com.warehouse.api.dto.ProductCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductCreateDTO findById(UUID id){
        Product product = productRepository.findById(id).orElseThrow();
        ProductCreateDTO productCreateDTO = convertToDto(product);
        return productCreateDTO;
    }
    public ProductCreateDTO save(ProductCreateDTO productDto){
        Product product = convertToEntity(productDto);
        product = productRepository.save(product);
        return convertToDto(product);
    }
    public ProductCreateDTO update(UUID id, ProductCreateDTO productDto){
        ProductCreateDTO ProductCreateDTO = null;
        Product product = convertToEntity(ProductCreateDTO);
        product.setId(id);
        product = productRepository.save(product);
        return convertToDto(product);
    }
    public void deleteById(UUID id){
        productRepository.deleteById(id);
    }
    public List<ProductCreateDTO> findAll(){
        List<Product> products = productRepository.findAll();
        List<ProductCreateDTO> productsDTO = new ArrayList<>();
        for(Product product : products){
            productsDTO.add(convertToDto(product));
        }
        return productsDTO;
    }
    public ProductCreateDTO convertToDto(Product product){
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setSku(product.getSku());
        productCreateDTO.setNome(product.getNome());
        return productCreateDTO;
    }
    public  Product convertToEntity(ProductCreateDTO productCreateDTO){
        Product product = new Product();
        product.setSku(productCreateDTO.getSku());
        product.setNome(productCreateDTO.getNome());
        return product;
    }
}
