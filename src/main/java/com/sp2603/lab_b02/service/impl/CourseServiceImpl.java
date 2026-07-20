package com.sp2603.lab_b02.service.impl;

import com.sp2603.lab_b02.data.course.domainObject.request.CreateCourseRequestData;
import com.sp2603.lab_b02.data.course.domainObject.request.UpdateCourseRequestData;
import com.sp2603.lab_b02.data.course.domainObject.response.CourseResponseData;
import com.sp2603.lab_b02.data.course.entity.CourseEntity;
import com.sp2603.lab_b02.data.person.entity.PersonEntity;
import com.sp2603.lab_b02.exception.course.*;
import com.sp2603.lab_b02.mapper.course.CourseDataMapper;
import com.sp2603.lab_b02.mapper.course.CourseEntityMapper;
import com.sp2603.lab_b02.repository.CourseRepository;
import com.sp2603.lab_b02.service.CourseService;
import com.sp2603.lab_b02.service.PersonService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);
    private final PersonService personService;
    private final CourseEntityMapper courseEntityMapper;
    private final CourseDataMapper courseDataMapper;
    private final CourseRepository courseRepository;
    //private List<CourseEntity> courseEntityList = new ArrayList<>();

    public CourseServiceImpl(PersonService personService, CourseEntityMapper courseEntityMapper, CourseDataMapper courseDataMapper, CourseRepository courseRepository) {
        this.personService = personService;
        this.courseEntityMapper = courseEntityMapper;
        this.courseDataMapper = courseDataMapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseResponseData createCourse(CreateCourseRequestData createCourseRequestData) {
        try {
            if(isCourseExist(createCourseRequestData.getCourseId())) {
                throw new CourseExistedException(createCourseRequestData.getCourseId());
            }
            /** Lv2
            PersonEntity teacherEntity = personService.getEntityByHkid(createCourseRequestData.getTeacherHkid());

            CourseEntity courseEntity = courseEntityMapper.toCourseEntity(createCourseRequestData,teacherEntity);
            courseEntityList.add(courseEntity);

            CourseResponseData courseResponseData = courseDataMapper.toCourseResponseData(courseEntity);

            return courseResponseData;
             **/

//            CourseEntity courseEntity = courseEntityMapper.toCourseEntity(
//                    createCourseRequestData,
//                    personService.getEntityByHkid(createCourseRequestData.getTeacherHkid())
//                    );

            //courseEntityList.add(courseEntity);
            //courseEntity = courseRepository.save(courseEntity);

            return courseDataMapper.toCourseResponseData(
                    courseRepository.save(
                            courseEntityMapper.toCourseEntity(
                                createCourseRequestData,
                                personService.getEntityByHkid(createCourseRequestData.getTeacherHkid())
                            )
                    )
            );

        } catch(Exception exception) {
            log.warn("Create Course Failed: {}", exception.getMessage());
            throw exception;
        }
    }

    @Override
    public List<CourseResponseData> getAllCourses() {
        /** Lv2
        List<CourseResponseData> courseResponseDataList = courseDataMapper.toCourseResponseDataList(courseEntityList);
        return courseResponseDataList;
         **/

        return courseDataMapper.toCourseResponseDataList(courseRepository.findAll());
    }

    @Override
    public CourseResponseData updateCourse(UpdateCourseRequestData updateCourseRequestData) {
        try {
            //Lv2
            //CourseEntity courseEntity = getEntityByCourseId(updateCourseRequestData.getCourseId());
            //PersonEntity teacherEntity = personService.getEntityByHkid(updateCourseRequestData.getTeacherHkid());

            //courseEntity.setCourseName(updateCourseRequestData.getCourseName());
            //courseEntity.setPrice(updateCourseRequestData.getPrice());
            //courseEntity.setTeacher(teacherEntity);

            //CourseResponseData courseResponseData = courseDataMapper.toCourseResponseData(courseEntity);
            //return courseResponseData;

            //Lv3
            CourseEntity courseEntity = getEntityByCourseId(updateCourseRequestData.getCourseId());

            courseEntity.setCourseName(updateCourseRequestData.getCourseName());
            courseEntity.setPrice(updateCourseRequestData.getPrice());
            courseEntity.setTeacher(
                    personService.getEntityByHkid(updateCourseRequestData.getTeacherHkid())
                    );

            return courseDataMapper.toCourseResponseData(courseRepository.save(courseEntity));

        } catch (Exception exception) {
            log.warn("Update Course Failed: {}", exception.getMessage());
            throw exception;
        }
    }

    @Override
    @Transactional
    public CourseResponseData deleteCourse(String courseId) {
        try {
            CourseEntity courseEntity = getEntityByCourseId(courseId);
            //courseEntityList.remove(courseEntity);
            courseRepository.delete(courseEntity);
            return courseDataMapper.toCourseResponseData(courseEntity);
        } catch(Exception exception) {
            log.warn("Delete Course Failed: {}", exception.getMessage());
            throw exception;
        }
    }

    @Override
    public CourseResponseData addStudent(String courseId, String hkid) {
        try {
//            Lv2
//            CourseEntity courseEntity = getEntityByCourseId(courseId);
//            PersonEntity studentEntity = personService.getEntityByHkid(hkid);

//            if(courseEntity.getTeacher().getHkid().equals(hkid)) {
//                 throw new StudentIsTeacherException(hkid);
//             }
//
//             for(PersonEntity entity : courseEntity.getStudents()) {
//                if(entity.getHkid().equals(hkid)) {
//                    throw new StudentDuplicatedException(hkid);
//                }
//            }
//            courseEntity.getStudents().add(studentEntity);
//            CourseResponseData courseResponseData = courseDataMapper.toCourseResponseData(courseEntity);
//            return courseResponseData;

            CourseEntity courseEntity = getEntityByCourseId(courseId);

            if(courseEntity.getTeacher().getHkid().equals(hkid)) {
                throw new StudentIsTeacherException(hkid);
            }

            for(PersonEntity entity : courseEntity.getStudents()) {
                if(entity.getHkid().equals(hkid)) {
                    throw new StudentDuplicatedException(hkid);
                }
            }

            courseEntity.getStudents().add(personService.getEntityByHkid(hkid));

            return courseDataMapper.toCourseResponseData(courseEntity);

        } catch(Exception exception) {
            log.warn("Add student to course Failed: {}", exception.getMessage());
            throw exception;
        }
    }

    @Override
    public CourseResponseData deleteStudent(String courseId, String hkid) {
        try {

            CourseEntity courseEntity = getEntityByCourseId(courseId);

            for(PersonEntity studentEntity : courseEntity.getStudents()) {
                if(studentEntity.getHkid().equals(hkid)) {
                    courseEntity.getStudents().remove(studentEntity);
                    return courseDataMapper.toCourseResponseData(courseEntity);
                }
            }

            throw new StudentNotFoundException(hkid);

        } catch (Exception exception) {
            log.warn("Delete student Failed: {}", exception.getMessage());
            throw exception;
        }
    }

    public boolean isCourseExist(String courseId) {
//        for(CourseEntity courseEntity: courseRepository.findAll()) {
//            if(courseEntity.getCourseId().equals(courseId)) {
//                return true;
//            }
//        }
//        return false;
        return courseRepository.existsById(courseId);
    }

    public CourseEntity getEntityByCourseId(String courseId) {
//        for(CourseEntity courseEntity:courseEntityList) {
//            if(courseEntity.getCourseId().equals(courseId)) {
//                return courseEntity;
//            }
//        }
//        throw new CourseNotFoundException(courseId);

        //return courseEntity;

        return courseRepository.findById(courseId).orElseThrow(
                () -> new CourseNotFoundException(courseId)
        );
    }
}
