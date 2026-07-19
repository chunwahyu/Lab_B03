package com.sp2603.lab_b02.data.course.domainObject.response;


import com.sp2603.lab_b02.data.person.domainObject.response.PersonResponseData;
import com.sp2603.lab_b02.data.person.entity.PersonEntity;

import java.util.ArrayList;
import java.util.List;

public class CourseResponseData {
    private String courseId;
    private String courseName;
    private Double price;
    private PersonResponseData teacher;
    private List<PersonResponseData> students = new ArrayList<>();

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

    public PersonResponseData getTeacher() {
        return teacher;
    }

    public void setTeacher(PersonResponseData teacher) {
        this.teacher = teacher;
    }

    public List<PersonResponseData> getStudents() {
        return students;
    }

    public void setStudents(List<PersonResponseData> students) {
        this.students = students;
    }
}
