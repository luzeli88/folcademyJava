package com.EspindolaLuz.primeraApi.Exceptions.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageDTO {
    private String message;
}
