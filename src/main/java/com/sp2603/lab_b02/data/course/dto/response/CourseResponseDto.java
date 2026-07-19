package com.sp2603.lab_b02.data.course.dto.response;


import com.sp2603.lab_b02.data.person.dto.response.PersonResponseDto;

import java.util.ArrayList;
import java.util.List;

public class CourseResponseDto {
    private String courseId;
    private String courseName;
    private Double price;
    private PersonResponseDto teacher;
    private List<PersonResponseDto> students = new ArrayList<>();

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PersonResponseDto getTeacher() {
        return teacher;
    }

    public void setTeacher(PersonResponseDto teacher) {
        this.teacher = teacher;
    }

    public List<PersonResponseDto> getStudents() {
        return students;
    }

    public void setStudents(List<PersonResponseDto> students) {
        this.students = students;
    }
}
