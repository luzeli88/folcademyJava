package com.EspindolaLuz.primeraApi.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class SaludoController {
    @GetMapping("/hello")
    public String hello(){return "Hola, soy Luz";}
    @PostMapping("/goodbye")
    public String goodbye(){
        return "Adios, hasta luego !!";
    }
}
