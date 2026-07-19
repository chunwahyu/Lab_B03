package com.sp2603.lab_b02.mapper.course;

import com.sp2603.lab_b02.data.course.domainObject.response.CourseResponseData;
import com.sp2603.lab_b02.data.course.dto.response.CourseResponseDto;
import com.sp2603.lab_b02.mapper.person.PersonDtoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseDtoMapper {
    private final PersonDtoMapper personDtoMapper;

    public CourseDtoMapper(PersonDtoMapper personDtoMapper) {
        this.personDtoMapper = personDtoMapper;
    }

    public CourseResponseDto toCourseResponseDto(CourseResponseData courseResponseData) {
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setCourseId(courseResponseData.getCourseId());
        courseResponseDto.setCourseName(courseResponseData.getCourseName());
        courseResponseDto.setPrice(courseResponseData.getPrice());
        courseResponseDto.setTeacher(
                personDtoMapper.toPersonResponseDto(courseResponseData.getTeacher())
        );
        courseResponseDto.setStudents(
                personDtoMapper.toPersonResponseDtoList(courseResponseData.getStudents())
        );

        return courseResponseDto;
    }

    public List<CourseResponseDto> toCourseResponseDtoList(List<CourseResponseData> courseResponseDataList) {
        List<CourseResponseDto> courseResponseDtoList = new ArrayList<>();
        for(CourseResponseData courseResponseData : courseResponseDataList) {
            courseResponseDtoList.add(toCourseResponseDto(courseResponseData));
        }
        return courseResponseDtoList;
    }
}
