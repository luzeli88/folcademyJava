package com.EspindolaLuz.primeraApi.Models.Mappers;

import com.EspindolaLuz.primeraApi.Models.Domain.UserAddDTO;
import com.EspindolaLuz.primeraApi.Models.Domain.UserReadDTO;
import com.EspindolaLuz.primeraApi.Models.Entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserReadDTO userEntityToUserReadDTO(UserEntity userEntity) {
        UserReadDTO userReadDTO = new UserReadDTO();
        userReadDTO.setId(userEntity.getId());
        userReadDTO.setName(userEntity.getName());
        userReadDTO.setSurname(userEntity.getSurname());
        userReadDTO.setEmail(userEntity.getEmail());
        return userReadDTO;
    }

    public UserEntity userAddDTOToUserEntity(UserAddDTO userAddDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userAddDTO.getName());
        userEntity.setSurname(userAddDTO.getSurname());
        userEntity.setEmail(userAddDTO.getEmail());
        userEntity.setPassword(userAddDTO.getPassword());
        return userEntity;
    }
}
