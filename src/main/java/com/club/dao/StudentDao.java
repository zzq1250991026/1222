package com.club.dao;

import com.club.bean.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentDao {
    /**
     * 添加学生信息
     */
    void addStudent(Student student);
    /**
     * 更新学生信息
     */
    void updateStudent(Student student);
    void updateStudentNoRole(Student student);
    /**
     * 根据学号删除学生信息
     */
    void deleteStudent(String id);
    /**
     * 根据id查找学生
     */
    Student selectStudentById(String id);
    //根据角色查询
    List<Student> selectStudentByRole(int role);
}
