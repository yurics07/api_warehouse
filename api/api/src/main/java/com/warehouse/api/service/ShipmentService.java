package com.warehouse.api.service;

import com.warehouse.api.Entity.Shipment;
import com.warehouse.api.Repository.ShipmentRepository;
import com.warehouse.api.dto.ShipmentCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;

    public ShipmentCreateDTO findById(UUID id) {
        Shipment shipment = shipmentRepository.findById(id).orElseThrow();
        ShipmentCreateDTO shipmentCreateDTO = convertToDto(shipment);
        return shipmentCreateDTO;
    }
    public ShipmentCreateDTO save(ShipmentCreateDTO shipmentCreateDTO){
        Shipment shipment = convertToEntity(shipmentCreateDTO);
        shipment = shipmentRepository.save(shipment);
        return convertToDto(shipment);
    }
    public ShipmentCreateDTO update(UUID id, ShipmentCreateDTO shipmentDto) {
        Shipment shipment = convertToEntity(shipmentDto);
        shipment.setId(id);
        shipment = shipmentRepository.save(shipment);
        return convertToDto(shipment);
    }
    public void deleteById(UUID id){
        shipmentRepository.deleteById(id);
    }
    public List<ShipmentCreateDTO> findAll(){
        List<Shipment> shipments = shipmentRepository.findAll();
        List<ShipmentCreateDTO> shipmentDTOS = new ArrayList<>();
        for (Shipment shipment : shipments){
            shipmentDTOS.add(convertToDto(shipment));
        }
        return shipmentDTOS;
    }
    public ShipmentCreateDTO convertToDto(Shipment shipment){
        ShipmentCreateDTO shipmentCreateDTO = new ShipmentCreateDTO();
        shipmentCreateDTO.setStatus(shipment.getStatus());
        return shipmentCreateDTO;
    }
    public Shipment convertToEntity(ShipmentCreateDTO shipmentCreateDTO){
        Shipment shipment = new Shipment();
        shipment.setStatus(shipmentCreateDTO.getStatus());
        return shipment;
    }

}
