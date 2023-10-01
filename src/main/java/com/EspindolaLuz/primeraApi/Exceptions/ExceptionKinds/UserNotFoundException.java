package com.EspindolaLuz.primeraApi.Exceptions.ExceptionKinds;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){ super (message); }

}
