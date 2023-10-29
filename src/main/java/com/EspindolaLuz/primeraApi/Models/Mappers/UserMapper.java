package com.EspindolaLuz.primeraApi.Models.Mappers;

import com.EspindolaLuz.primeraApi.Models.Dtos.UserAddDTO;
import com.EspindolaLuz.primeraApi.Models.Dtos.UserReadDTO;
import com.EspindolaLuz.primeraApi.Models.Entities.AutomobileEntity;
import com.EspindolaLuz.primeraApi.Models.Entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    private final AddressMapper addressMapper;
    private final AutomobileMapper automobileMapper;
    public UserMapper(AddressMapper addressMapper, AutomobileMapper automobileMapper) {
        this.addressMapper = addressMapper;
        this.automobileMapper = automobileMapper;
    }

    public UserReadDTO userEntityToUserReadDTO(UserEntity userEntity, List<AutomobileEntity> automobileEntities) {
        UserReadDTO userReadDTO = new UserReadDTO();
        userReadDTO.setId(userEntity.getId());
        userReadDTO.setName(userEntity.getName());
        userReadDTO.setSurname(userEntity.getSurname());
        userReadDTO.setEmail(userEntity.getEmail());
        userReadDTO.setAddress(addressMapper.addressEntityToAddressReadDTO(userEntity.getAddress()));

        if(Objects.nonNull(automobileEntities)) {
            userReadDTO.setAutomobiles(
                    automobileEntities
                            .stream()
                            .map(automobileMapper::automobileEntityToAutomobileReadDTO)
                            .collect(Collectors.toList())
            );
        }
        return userReadDTO;
    }
    public UserEntity userAddDTOToUserEntity(UserAddDTO userAddDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userAddDTO.getName());
        userEntity.setSurname(userAddDTO.getSurname());
        userEntity.setEmail(userAddDTO.getEmail());
        userEntity.setPassword(userAddDTO.getPassword());

        userEntity.setAddress(addressMapper.addressReadDTOToAddressEntity(userAddDTO.getAddress()));
        return userEntity;
    }
}
