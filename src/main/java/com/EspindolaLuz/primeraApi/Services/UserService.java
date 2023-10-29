package com.EspindolaLuz.primeraApi.Services;

import com.EspindolaLuz.primeraApi.Exceptions.ExceptionKinds.UserBadRequestException;
import com.EspindolaLuz.primeraApi.Exceptions.ExceptionKinds.UserNotFoundException;
import com.EspindolaLuz.primeraApi.Models.Dtos.UserAddDTO;
import com.EspindolaLuz.primeraApi.Models.Dtos.UserEditDTO;
import com.EspindolaLuz.primeraApi.Models.Dtos.UserReadDTO;
import com.EspindolaLuz.primeraApi.Models.Entities.AutomobileEntity;
import com.EspindolaLuz.primeraApi.Models.Entities.UserEntity;
import com.EspindolaLuz.primeraApi.Models.Mappers.UserMapper;
import com.EspindolaLuz.primeraApi.Models.Repositories.AutomobileRepository;
import com.EspindolaLuz.primeraApi.Models.Repositories.UserRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AutomobileRepository automobileRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper, AutomobileRepository automobileRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.automobileRepository = automobileRepository;
    }


   // public List<UserReadDTO> findAll() {
    //  List<UserReadDTO> users = new ArrayList<>();
       // List<UserEntity> userEntities = userRepository.findAll();
       // for (UserEntity userEntity : userEntities) {
          //  List<AutomobileEntity> automobileEntities = automobileRepository.findAllByUserId(userEntity.getId());
         //  UserReadDTO userReadDTO = userMapper.userEntityToUserReadDTO(userEntity, automobileEntities);
          // users.add(userReadDTO);
      //  }
       // return users;
  //  }
    public Page<UserReadDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());

        Page<UserEntity> userEntities = userRepository.findAll(pageable);
        List<UserReadDTO> users = userEntities
                .stream()
                .map(userEntity -> {
                    List<AutomobileEntity> automobileEntities = automobileRepository
                            .findAllByUserId(userEntity.getId());
                    return userMapper.userEntityToUserReadDTO(userEntity, automobileEntities);
                })
                .collect(Collectors.toList());
        return new PageImpl<>(users, pageable, userEntities.getTotalElements());
    }

    public UserReadDTO add(UserAddDTO userAddDTO) {
        Boolean emailExist = userRepository.existsByEmail(userAddDTO.getEmail());
        if (emailExist) throw new UserBadRequestException("Ya existe un usuario con ese email.");

        UserEntity userEntity = userMapper.userAddDTOToUserEntity(userAddDTO);
        userRepository.save(userEntity);
        return userMapper.userEntityToUserReadDTO(userEntity, null);
    }

    public UserReadDTO findById(Integer userId) {
        return null;
    }

    public UserReadDTO findUserById(Integer userId) {

        return null;
    }

    public UserReadDTO deleteById(Integer userId) {
        if (Objects.isNull(userId)) throw new UserBadRequestException("No esta definido el Id del usuario");
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("No se encontro el usuario con el Id especificado"));
        List<AutomobileEntity> automobileEntities = automobileRepository.findAllByUserId(userEntity.getId());
        UserReadDTO user = userMapper.userEntityToUserReadDTO(userEntity, automobileEntities);
        automobileRepository.deleteAll(automobileEntities);
        userRepository.delete(userEntity);
        return user;
    }

    public UserReadDTO edit(Integer userId, UserEditDTO user) {
        return null;
    }
}
