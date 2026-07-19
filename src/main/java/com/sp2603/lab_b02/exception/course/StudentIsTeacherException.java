package com.sp2603.lab_b02.exception.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentIsTeacherException extends RuntimeException {
    public StudentIsTeacherException(String hkid) {
        super("Student is Teacher: " + hkid);
    }
}
