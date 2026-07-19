package com.sp2603.lab_b02.exception.person;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonDataMissingException extends RuntimeException{
    public PersonDataMissingException(String data) {
        super(String.format("%s is missing" , data));
    }
}
