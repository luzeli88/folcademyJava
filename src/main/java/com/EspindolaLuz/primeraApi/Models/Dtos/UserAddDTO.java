package com.EspindolaLuz.primeraApi.Models.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserAddDTO {

    String name;
    String surname;
    //long celular;
    String email;
    String password;

}
