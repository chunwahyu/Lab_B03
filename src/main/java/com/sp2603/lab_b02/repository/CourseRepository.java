package com.sp2603.lab_b02.repository;

import com.sp2603.lab_b02.data.course.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<CourseEntity, String> {

}
