package com.EspindolaLuz.primeraApi.Models.Dtos;

import com.EspindolaLuz.primeraApi.Models.Entities.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
    private AddressReadDTO address;

}
