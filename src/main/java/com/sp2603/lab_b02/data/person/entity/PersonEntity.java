package com.sp2603.lab_b02.data.person.entity;

import com.sp2603.lab_b02.data.course.entity.CourseEntity;
import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;

import java.util.List;

@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Nullable Integer pid;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String hkid;

    @OneToMany(mappedBy = "teacher")
    private List<CourseEntity> courseTeaching;

    @ManyToMany(mappedBy = "students")
    private List<CourseEntity> courseJoining;

    public @Nullable Integer getPid() {
        return pid;
    }

    public void setPid(@Nullable Integer pid) {
        this.pid = pid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHkid() {
        return hkid;
    }

    public void setHkid(String hkid) {
        this.hkid = hkid;
    }

    public List<CourseEntity> getCourseTeaching() {
        return courseTeaching;
    }

    public void setCourseTeaching(List<CourseEntity> courseTeaching) {
        this.courseTeaching = courseTeaching;
    }

    public List<CourseEntity> getCourseJoining() {
        return courseJoining;
    }

    public void setCourseJoining(List<CourseEntity> courseJoining) {
        this.courseJoining = courseJoining;
    }
}
