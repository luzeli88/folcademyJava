package com.EspindolaLuz.primeraApi.Models.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserAddDTO {

   private String name;
   private String surname;
    //long celular;
   private String email;
   private String password;
   private  AddressReadDTO address;
}
