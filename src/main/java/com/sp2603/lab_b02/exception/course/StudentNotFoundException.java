package com.sp2603.lab_b02.exception.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String hkid) {
        super("Student not found: " + hkid);
    }
}
