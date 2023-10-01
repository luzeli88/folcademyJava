package com.EspindolaLuz.primeraApi.Exceptions.ExceptionKinds;

public class UserBadRequestException extends RuntimeException{
    public UserBadRequestException(String message){super(message);}
}
