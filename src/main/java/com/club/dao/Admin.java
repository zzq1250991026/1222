package com.club.dao;

import com.club.bean.Course;
import com.club.bean.Student;
import com.club.bean.Study;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface Admin {
     List<Student> selectAllStudents();

     List<Course> selectAllCourses();

     void updateStudent(Student student);

     Student selectStuById(String id);

     void addStudent(Student student);

    void delStudent(String id);

     void addCourse(Course course);

     void delCourse(Integer id);

     List<Study> selectAllStudyInfo();

     void addStudyInfo(Study studyInfo);

     void delStudyInfo(Integer id);

     Study selectById(Integer id);

     void delStudyInfoByCId(Integer id);

     void delStudyInfoBySId(String id);
}
