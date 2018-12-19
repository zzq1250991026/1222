package com.club.service.impl;

import com.club.bean.Student;
import com.club.dao.StudentDao;
import com.club.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void updateStudentNoRole(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(String id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public Student selectStudentById(String id) {
        return studentDao.selectStudentById(id);
    }

    @Override
    public List<Student> selectStudentByRole(int role) {
        return studentDao.selectStudentByRole(role);
    }
    /**
     *  @return 0 成功,1 已经选过此课程,2 已选满,-1 未知错误
     */
    @Override
    public Student login(String id, String pwd) {
        return null;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public int selectCource(String stuId, Integer clzId) {
        return 0;
    }

    @Override
    public boolean changePwd(String stuId, String old, String newpwd) {
        return false;
    }
}
