package com.sp2603.lab_b02.exception.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentDuplicatedException extends RuntimeException{
    public StudentDuplicatedException(String hkid) {
        super("Student Duplicated: " + hkid);
    }
}
