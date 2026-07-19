package com.sp2603.lab_b02.mapper.course;

import com.sp2603.lab_b02.data.course.domainObject.request.CreateCourseRequestData;
import com.sp2603.lab_b02.data.course.entity.CourseEntity;
import com.sp2603.lab_b02.data.person.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityMapper {
    public CourseEntity toCourseEntity(CreateCourseRequestData createCourseRequestData, PersonEntity teacher) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseId(createCourseRequestData.getCourseId());
        courseEntity.setCourseName(createCourseRequestData.getCourseName());
        courseEntity.setPrice(createCourseRequestData.getPrice());
        courseEntity.setTeacher(teacher);

        return courseEntity;
    }
}
