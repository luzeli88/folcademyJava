package com.EspindolaLuz.primeraApi.Models.Mappers;

import com.EspindolaLuz.primeraApi.Models.Dtos.AddressReadDTO;
import com.EspindolaLuz.primeraApi.Models.Entities.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {


    public AddressReadDTO addressEntityToAddressReadDTO(AddressEntity addressEntity) {
        AddressReadDTO addressReadDTO = new AddressReadDTO();
        addressReadDTO.setNumber(addressEntity.getNumber());
        addressReadDTO.setStreet(addressEntity.getStreet());
        return  addressReadDTO;
    }

    public AddressEntity addressReadDTOToAddressEntity(AddressReadDTO address) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(address.getStreet());
        addressEntity.setNumber (address.getStreet());
        return addressEntity;
    }
}
