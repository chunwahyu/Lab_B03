package com.sp2603.lab_b02.mapper.course;

import com.sp2603.lab_b02.data.course.domainObject.request.CreateCourseRequestData;
import com.sp2603.lab_b02.data.course.domainObject.request.UpdateCourseRequestData;
import com.sp2603.lab_b02.data.course.domainObject.response.CourseResponseData;
import com.sp2603.lab_b02.data.course.dto.request.CreateCourseRequestDto;
import com.sp2603.lab_b02.data.course.dto.request.UpdateCourseRequestDto;
import com.sp2603.lab_b02.data.course.entity.CourseEntity;
import com.sp2603.lab_b02.mapper.person.PersonDataMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseDataMapper {

    private final PersonDataMapper personDataMapper;

    public CourseDataMapper(PersonDataMapper personDataMapper) {
        this.personDataMapper = personDataMapper;
    }

    public CreateCourseRequestData toCreateCourseRequestData(CreateCourseRequestDto createCourseRequestDto) {
       CreateCourseRequestData createCourseRequestData = new CreateCourseRequestData();
       createCourseRequestData.setCourseId(createCourseRequestDto.getCourseId());
       createCourseRequestData.setCourseName(createCourseRequestDto.getCourseName());
       createCourseRequestData.setPrice(createCourseRequestDto.getPrice());
       createCourseRequestData.setTeacherHkid(createCourseRequestDto.getTeacherHkid());

       return createCourseRequestData;
    }

    public UpdateCourseRequestData toUpdateCourseRequestData(UpdateCourseRequestDto updateCourseRequestDto) {
        UpdateCourseRequestData updateCourseRequestData = new UpdateCourseRequestData();
        updateCourseRequestData.setCourseId(updateCourseRequestDto.getCourseId());
        updateCourseRequestData.setCourseName(updateCourseRequestDto.getCourseName());
        updateCourseRequestData.setPrice(updateCourseRequestDto.getPrice());
        updateCourseRequestData.setTeacherHkid(updateCourseRequestDto.getTeacherHkid());

        return updateCourseRequestData;
    }

    public CourseResponseData toCourseResponseData(CourseEntity courseEntity) {
        CourseResponseData courseResponseData = new CourseResponseData();
        courseResponseData.setCourseId(courseEntity.getCourseId());
        courseResponseData.setCourseName(courseEntity.getCourseName());
        courseResponseData.setPrice(courseEntity.getPrice());
        courseResponseData.setTeacher(
                personDataMapper.toPersonResponseData(courseEntity.getTeacher())
        );
        courseResponseData.setStudents(personDataMapper.toPersonResponseDataList(courseEntity.getStudents()));

        return courseResponseData;
    }

    public List<CourseResponseData> toCourseResponseDataList(List<CourseEntity> courseEntityList) {
        List<CourseResponseData> courseResponseDataList = new ArrayList<>();
        for(CourseEntity courseEntity : courseEntityList) {
            courseResponseDataList.add(toCourseResponseData(courseEntity));
        }

        return courseResponseDataList;
    }
}
