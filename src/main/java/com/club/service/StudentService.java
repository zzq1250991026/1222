package com.club.service;

import com.club.bean.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
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

    //具体Service
    Student login(String id,String pwd);
    boolean update(Student student);
    boolean delete(String id);
    /**
     *  @return 0 成功,1 已经选过此课程,2 已选满,-1 未知错误
     */
    int selectCource(String stuId, Integer clzId);

    boolean changePwd(String stuId, String old,String newpwd);
}
