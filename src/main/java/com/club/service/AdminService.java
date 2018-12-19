package com.club.service;

import com.club.bean.Course;
import com.club.bean.Student;
import com.club.bean.Study;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminService {
    boolean login(String username, String pwd);

     List<Student> getAllStudents();

     List<Course> getAllCourses();

    boolean updateStudent(Student student);

     Student getStudentById(String id);

     boolean addStudent(Student student);

     void delStudent(String id);

     boolean addCourse(Course course);

    boolean updateCourse(Course course);

    void delCourse(Integer id);

     Course getCourseById(Integer id);

    List<Study> getAllStudyInfo();

     void addStudyInfo(Study study);

     void delStudyInfo(Integer id);

     Study getStudyById(Integer id);
}
