package com.sp2603.lab_b02.service;

import com.sp2603.lab_b02.data.course.domainObject.request.CreateCourseRequestData;
import com.sp2603.lab_b02.data.course.domainObject.request.UpdateCourseRequestData;
import com.sp2603.lab_b02.data.course.domainObject.response.CourseResponseData;

import java.util.List;

public interface CourseService {


    CourseResponseData createCourse(CreateCourseRequestData createCourseRequestData);

    List<CourseResponseData> getAllCourses();

    CourseResponseData updateCourse(UpdateCourseRequestData updateCourseRequestData);

    CourseResponseData deleteCourse(String courseId);

    CourseResponseData addStudent(String courseId, String hkid);

    CourseResponseData deleteStudent(String courseId, String hkid);
}
