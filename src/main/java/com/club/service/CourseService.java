package com.club.service;

import com.club.bean.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CourseService {

     List<Course> getAllClz();

     Course getClzById(Integer id);

     void update(Course course);
     void delectCourse(Integer id);
     void addCourse(Course course);
}
