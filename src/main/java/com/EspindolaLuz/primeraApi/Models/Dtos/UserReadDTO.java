package com.EspindolaLuz.primeraApi.Models.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserReadDTO {
   private Integer id;
   private String name;
   private String surname;
   private String email;
   private AddressReadDTO address;
   private List<AutomobileReadDTO> automobiles;
}
