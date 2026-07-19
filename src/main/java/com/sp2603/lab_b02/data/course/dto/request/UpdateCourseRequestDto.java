package com.sp2603.lab_b02.data.course.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class UpdateCourseRequestDto {

    @NotBlank
    @JsonProperty("course_id")
    private String courseId;

    @NotBlank
    @JsonProperty("course_name")
    private String courseName;

    @Positive
    @JsonProperty("price")
    private Double price;

    @NotBlank
    @JsonProperty("teacher_hkid")
    private String teacherHkid;

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

    public String getTeacherHkid() {
        return teacherHkid;
    }

    public void setTeacherHkid(String teacherHkid) {
        this.teacherHkid = teacherHkid;
    }
}
