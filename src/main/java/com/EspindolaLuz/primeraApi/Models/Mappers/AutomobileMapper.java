package com.EspindolaLuz.primeraApi.Models.Mappers;

import com.EspindolaLuz.primeraApi.Models.Dtos.AutomobileAddDTO;
import com.EspindolaLuz.primeraApi.Models.Dtos.AutomobileEditDTO;
import com.EspindolaLuz.primeraApi.Models.Dtos.AutomobileReadDTO;
import com.EspindolaLuz.primeraApi.Models.Entities.AutomobileEntity;
import com.EspindolaLuz.primeraApi.Models.Repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class AutomobileMapper {
    private final UserRepository userRepository;
    public AutomobileMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public AutomobileReadDTO automobileEntityToAutomobileReadDTO(AutomobileEntity automobileEntity) {
        AutomobileReadDTO automobileReadDTO = new AutomobileReadDTO();
        automobileReadDTO.setBrand(automobileEntity.getBrand());
        automobileReadDTO.setModel(automobileEntity.getModel());
        automobileReadDTO.setPatent(automobileEntity.getPatent());
        return automobileReadDTO;
    }
    public AutomobileEntity automobileAddDTToAutomobileEntity(AutomobileAddDTO automobileAddDTO) {
        AutomobileEntity automobileEntity = new AutomobileEntity();
        automobileEntity.setBrand(automobileAddDTO.getBrand());
        automobileEntity.setModel(automobileAddDTO.getModel());
        automobileEntity.setPatent(automobileAddDTO.getPatent());
        automobileEntity.setUser(userRepository.findById(automobileAddDTO.getUserId()).orElse(null));
        return automobileEntity;
    }

    public AutomobileEntity automobileEditDTOToAutomobileEntity(AutomobileEntity automobileEntity, AutomobileEditDTO automobileEditDTO) {
        automobileEntity.setPatent(automobileEditDTO.getPatent());
        automobileEntity.setModel(automobileEditDTO.getModel());
        automobileEntity.setBrand(automobileEditDTO.getBrand());
        return automobileEntity;
    }
}