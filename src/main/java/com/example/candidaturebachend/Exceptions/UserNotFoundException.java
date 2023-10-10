package com.example.candidaturebachend.Exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String Message)   {
        super(Message);

    }
}
