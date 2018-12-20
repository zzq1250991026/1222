package com.club.dao;

import com.club.bean.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CourseDao {
    List<Course> selectAll();

    Course selectById(Integer id);

    void update(Course course);
    void delectCourse(Integer id);
    void addCourse(Course course);
}
