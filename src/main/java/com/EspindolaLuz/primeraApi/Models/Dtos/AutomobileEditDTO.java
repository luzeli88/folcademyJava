package com.EspindolaLuz.primeraApi.Models.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomobileEditDTO {
    private String brand;
    private String model;
    private String patent;
}