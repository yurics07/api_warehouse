package com.warehouse.api.controller;

import com.warehouse.api.dto.AddressCreateDTO;
import com.warehouse.api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    @Autowired

    AddressService service;

    @GetMapping("/{id}")
    public AddressCreateDTO findById(@PathVariable("id") UUID id){
        return service.findById(id);
    }
    @GetMapping
    public List<AddressCreateDTO> findAll(){
        return service.findAll();
    }
    @PostMapping("/{id}")
    public AddressCreateDTO update(
            @PathVariable("id")UUID id,@RequestBody AddressCreateDTO addressCreateDTO){
        return service.update(id,addressCreateDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")UUID id) {
        service.deleteById(id);
    }
    
}
