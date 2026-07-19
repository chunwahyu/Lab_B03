package com.sp2603.lab_b02.controller;

import com.sp2603.lab_b02.data.course.domainObject.request.CreateCourseRequestData;
import com.sp2603.lab_b02.data.course.domainObject.request.UpdateCourseRequestData;
import com.sp2603.lab_b02.data.course.domainObject.response.CourseResponseData;
import com.sp2603.lab_b02.data.course.dto.request.CreateCourseRequestDto;
import com.sp2603.lab_b02.data.course.dto.request.UpdateCourseRequestDto;
import com.sp2603.lab_b02.data.course.dto.response.CourseResponseDto;
import com.sp2603.lab_b02.mapper.course.CourseDataMapper;
import com.sp2603.lab_b02.mapper.course.CourseDtoMapper;
import com.sp2603.lab_b02.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Validated
public class CourseController {

    private final CourseDataMapper courseDataMapper;
    private final CourseService courseService;
    private final CourseDtoMapper courseDtoMapper;

    public CourseController(CourseDataMapper courseDataMapper, CourseService courseService, CourseDtoMapper courseDtoMapper) {
        this.courseDataMapper = courseDataMapper;
        this.courseService = courseService;
        this.courseDtoMapper = courseDtoMapper;
    }

    @PostMapping
    public CourseResponseDto createCourse(@Valid @RequestBody CreateCourseRequestDto createCourseRequestDto) {
        /** Lv2
        CreateCourseRequestData createCourseRequestData = courseDataMapper.toCreateCourseRequestData(createCourseRequestDto);
        CourseResponseData courseResponseData = courseService.createCourse(createCourseRequestData);
        CourseResponseDto courseResponseDto = courseDtoMapper.toCourseResponseDto(courseResponseData);
        return courseResponseDto;
         **/

        return courseDtoMapper.toCourseResponseDto(
                courseService.createCourse(
                        courseDataMapper.toCreateCourseRequestData(createCourseRequestDto)
                )
        );
    }

    @GetMapping
    public List<CourseResponseDto> getAllCourses() {
        /** Lv2
        List<CourseResponseData> courseResponseDataList = courseService.getAllCourses();
        List<CourseResponseDto> courseResponseDtoList = courseDtoMapper.toCourseResponseDtoList(courseResponseDataList);
        return courseResponseDtoList;
         **/

        return courseDtoMapper.toCourseResponseDtoList(
                courseService.getAllCourses()
        );
    }

    @PutMapping
    public CourseResponseDto updateCourse(@Valid @RequestBody UpdateCourseRequestDto updateCourseRequestDto) {

//        Lv2
//        UpdateCourseRequestData updateCourseRequestData = courseDataMapper.toUpdateCourseRequestData(updateCourseRequestDto);
//        CourseResponseData courseResponseData = courseService.updateCourse(updateCourseRequestData);
//        CourseResponseDto courseResponseDto = courseDtoMapper.toCourseResponseDto(courseResponseData);
//
//        return courseResponseDto;

        return courseDtoMapper.toCourseResponseDto(
                courseService.updateCourse(
                        courseDataMapper.toUpdateCourseRequestData(updateCourseRequestDto)
                )
        );
    }

    @DeleteMapping("/{course_id}")
    public CourseResponseDto deleteCourse(@NotBlank @PathVariable(value = "course_id") String courseId) {
//        Lv2
//        CourseResponseData courseResponseData = courseService.deleteCourse(courseId);
//        CourseResponseDto courseResponseDto = courseDtoMapper.toCourseResponseDto(courseResponseData);
//        return courseResponseDto;

        return courseDtoMapper.toCourseResponseDto(
                courseService.deleteCourse(courseId)
        );

    }

    @PostMapping("/{course_id}/students/{person_hkid}")
    public CourseResponseDto addStudent(@PathVariable(value = "course_id") String courseId,
                                        @PathVariable(value = "person_hkid") String personHkid) {
//        Lv2
//        CourseResponseData courseResponseData = courseService.addStudent(courseId, personHkid);
//        CourseResponseDto courseResponseDto = courseDtoMapper.toCourseResponseDto(courseResponseData);
//        return courseResponseDto;

        return courseDtoMapper.toCourseResponseDto(
                courseService.addStudent(courseId, personHkid)
        );
    }

    @DeleteMapping("/{course_id}/students/{person_hkid}")
    public CourseResponseDto deleteStudent(@PathVariable(value = "course_id") String courseId,
                                        @PathVariable(value = "person_hkid") String personHkid) {
//        Lv2
//        CourseResponseData courseResponseData = courseService.deleteStudent(courseId, personHkid);
//        CourseResponseDto courseResponseDto = courseDtoMapper.toCourseResponseDto(courseResponseData);
//        return courseResponseDto;

        return courseDtoMapper.toCourseResponseDto(
                courseService.deleteStudent(courseId, personHkid)
        );
    }
}
