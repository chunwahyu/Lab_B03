package com.sp2603.lab_b02.data.course.domainObject.request;

public class UpdateCourseRequestData {

    private String courseId;
    private String courseName;
    private Double price;
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
