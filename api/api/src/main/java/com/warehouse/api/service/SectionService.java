package com.warehouse.api.service;

import com.warehouse.api.Entity.Section;
import com.warehouse.api.Repository.SectionRepository;
import com.warehouse.api.dto.SectionCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public SectionCreateDTO findById(UUID id) {
        Section section = sectionRepository.findById(id).orElseThrow();
        SectionCreateDTO sectionCreateDTO = convertToDto(section);
        return sectionCreateDTO;
    }
    public SectionCreateDTO save(SectionCreateDTO sectionCreateDTO) {
        Section section = convertToEntity(sectionCreateDTO);
        section = sectionRepository.save(section);
        return convertToDto(section);
    }
    public SectionCreateDTO update(UUID id, SectionCreateDTO sectionCreateDTO){
        Section section = convertToEntity(sectionCreateDTO);
        section.setId(id);
        section = sectionRepository.save(section);
        return convertToDto(section);
    }

    public void deleteById(UUID id){
        sectionRepository.deleteById(id);
    }
    public List<SectionCreateDTO> findAll(){
        List<Section> sections = sectionRepository.findAll();
        List<SectionCreateDTO> sectionsDTO = new ArrayList<>();
        for (Section section : sections) {
            sectionsDTO.add(convertToDto(section));
        }
        return sectionsDTO;
    }
    public SectionCreateDTO convertToDto(Section section){
        SectionCreateDTO sectionCreateDTO = new SectionCreateDTO();

        sectionCreateDTO.setCode(section.getCode());
        return sectionCreateDTO;
    }
    public Section convertToEntity(SectionCreateDTO sectionCreateDTO){
        Section section = new Section();
        section.setCode(sectionCreateDTO.getCode());
        return section;
    }

}
