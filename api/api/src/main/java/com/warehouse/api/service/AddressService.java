package com.warehouse.api.service;

import com.warehouse.api.Entity.Address;
import com.warehouse.api.Repository.AddressRepository;
import com.warehouse.api.dto.AddressCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public AddressCreateDTO findById(UUID id ){
        Address address = addressRepository.findById(id).orElseThrow();
        AddressCreateDTO addressCreateDTO = convertToDto(address);
        return addressCreateDTO;
    }
    public AddressCreateDTO save(AddressCreateDTO addressCreateDTO){
        Address address = convertToEntity(addressCreateDTO);
        address = addressRepository.save(address);
        return convertToDto(address);
    }

    public AddressCreateDTO update(UUID id, AddressCreateDTO addressCreateDTO){
        Address address = convertToEntity(addressCreateDTO);
        address.setId(id);
        address = addressRepository.save(address);
        return convertToDto(address);
    }
    public void deleteById(UUID id){
        addressRepository.deleteById(id);


    }
    public List<AddressCreateDTO>findAll(){
        List<Address> addresses = addressRepository.findAll();
        List<AddressCreateDTO> addressDtos = new ArrayList<>();
        for(Address address:addresses){
            addressDtos.add(convertToDto(address));

    }
        return addressDtos;
    }
    public AddressCreateDTO convertToDto(Address address){
        AddressCreateDTO addressCreateDTO = new AddressCreateDTO();
        addressCreateDTO.setStreet(address.getStreet());
        addressCreateDTO.setCity(address.getCity());

        return addressCreateDTO;
    }

    public Address convertToEntity(AddressCreateDTO addressCreateDTO){
        Address address = new Address();
        address.setStreet(addressCreateDTO.getStreet());
        address.setCity(addressCreateDTO.getCity());
        return address;
    }



}
