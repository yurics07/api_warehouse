package com.warehouse.api.service;

import com.warehouse.api.Entity.Warehouse;
import com.warehouse.api.Repository.WarehouseRepository;
import com.warehouse.api.dto.WarehouseCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    public WarehouseCreateDTO findById(UUID id){
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow();
        WarehouseCreateDTO warehouseCreateDTO = convertToDto(warehouse);
        return warehouseCreateDTO;
    }
    public WarehouseCreateDTO save(WarehouseCreateDTO warehouseCreateDTO){
        Warehouse warehouse = convertToEntity(warehouseCreateDTO);
        warehouse = warehouseRepository.save(warehouse);
        return convertToDto(warehouse);
    }
    public WarehouseCreateDTO update(UUID id, WarehouseCreateDTO warehouseCreateDTO){
        Warehouse warehouse = convertToEntity(warehouseCreateDTO);
        warehouse.setId(id);
        warehouse = warehouseRepository.save(warehouse);
        return convertToDto(warehouse);
    }
    public void deleteById(UUID id){
        warehouseRepository.deleteById(id);
    }
    public List<WarehouseCreateDTO> findAll(){
        List<Warehouse> warehouses = warehouseRepository.findAll();
        List<WarehouseCreateDTO> warehouseDTOS = new ArrayList<>();
        for(Warehouse warehouse : warehouses){
            warehouseDTOS.add(convertToDto(warehouse));
        }
        return warehouseDTOS;
    }
    public WarehouseCreateDTO convertToDto(Warehouse warehouse){
        WarehouseCreateDTO warehouseCreateDTO = new WarehouseCreateDTO();
        warehouseCreateDTO.setName(warehouse.getName());
        return warehouseCreateDTO;
    }
    public Warehouse convertToEntity(WarehouseCreateDTO warehouseCreateDTO){
        Warehouse warehouse = new Warehouse();
        warehouse.setName(warehouseCreateDTO.getName());
        return warehouse;
    }
}
