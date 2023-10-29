package com.EspindolaLuz.primeraApi.Services;

import com.EspindolaLuz.primeraApi.Exceptions.ExceptionKinds.UserBadRequestException;
import com.EspindolaLuz.primeraApi.Exceptions.ExceptionKinds.UserNotFoundException;
import com.EspindolaLuz.primeraApi.Models.Dtos.AutomobileAddDTO;
import com.EspindolaLuz.primeraApi.Models.Dtos.AutomobileEditDTO;
import com.EspindolaLuz.primeraApi.Models.Dtos.AutomobileReadDTO;
import com.EspindolaLuz.primeraApi.Models.Entities.AutomobileEntity;
import com.EspindolaLuz.primeraApi.Models.Mappers.AutomobileMapper;
import com.EspindolaLuz.primeraApi.Models.Repositories.AutomobileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AutomobileService {
    private final AutomobileRepository automobileRepository;
    private final AutomobileMapper automobileMapper;

    public AutomobileService(AutomobileRepository automobileRepository, AutomobileMapper automobileMapper) {
        this.automobileRepository = automobileRepository;
        this.automobileMapper = automobileMapper;
    }

    public List<AutomobileReadDTO> findAll() {
        return automobileRepository.findAll()
                .stream()
                .map(automobileMapper::automobileEntityToAutomobileReadDTO)
                .collect(Collectors.toList());
    }

    public AutomobileReadDTO add(AutomobileAddDTO automobileAddDTO) {
        AutomobileEntity automobileEntity = automobileMapper.automobileAddDTToAutomobileEntity (automobileAddDTO);
        automobileRepository.save(automobileEntity);
        return automobileMapper.automobileEntityToAutomobileReadDTO(automobileEntity);
    }

    public AutomobileReadDTO findById(Integer automobileId) {
        return automobileRepository.findById(automobileId)
                .map(automobileMapper::automobileEntityToAutomobileReadDTO)
                .orElseThrow(()-> new UserNotFoundException("Automobile Not Found"));
    }

    public AutomobileReadDTO edit(Integer automobileId, AutomobileEditDTO automobileEditDTO) {
        if (Objects.isNull(automobileId)) throw new UserBadRequestException("No esta definido el id de usuario");

        AutomobileEntity automobileEntity = automobileRepository.findById(automobileId)
                .orElseThrow(()-> new UserNotFoundException("No se encontro el vehiculo con el id especificado"));

        AutomobileEntity newAutomobile = automobileMapper.automobileEditDTOToAutomobileEntity(automobileEntity, automobileEditDTO);
        automobileRepository.save(newAutomobile);
        return automobileMapper.automobileEntityToAutomobileReadDTO(newAutomobile);
    }

    public AutomobileReadDTO deleteById(Integer automobileId) {
        if (Objects.isNull(automobileId)) throw new UserBadRequestException("No esta definido el id de vehiculo");
        AutomobileEntity automobileEntity = automobileRepository.findById(automobileId)
                .orElseThrow(()-> new UserNotFoundException("No se encontro el usuario con el id especificado"));

        AutomobileReadDTO automobile = automobileMapper.automobileEntityToAutomobileReadDTO(automobileEntity);
        automobileRepository.delete (automobileEntity);
        return automobile;
    }
}
