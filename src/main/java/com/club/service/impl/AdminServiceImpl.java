package com.club.service.impl;

import com.club.bean.Course;
import com.club.bean.Student;
import com.club.bean.Study;
import com.club.dao.Admin;
import com.club.dao.CourseDao;
import com.club.dao.StudentDao;
import com.club.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private Admin admin;

    @Autowired
    private CourseDao clzDao;
    @Autowired
    private StudentDao studentDao;
    private Integer id;

    //用户登录
    @Override
    public boolean login(String id, String pwd) {
        Student student = studentDao.selectStudentById(id);
        if (student != null && student.getPwd().equals(pwd)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Student> getAllStudents() {
        return admin.selectAllStudents();
    }

    @Override
    public List<Course> getAllCourses() {
        return admin.selectAllCourses();
    }

    @Override
    public boolean updateStudent(Student student) {
        if (student.getId() != null && student.getId().length() != 0) {
            String name = student.getName().trim();
            if (name != null && name.length() <= 20 && name.length() > 0) {
                String pwd = student.getPwd().trim();
                if (pwd != null && pwd.length() <= 20 && pwd.length() > 0) {
                    String major = student.getMajor().trim();
                    if (major != null && major.length() <= 100 && major.length() > 0) {
                        String year = student.getYear();
                        if (year.length() == 4) {
                            for (int i = 0; i < 4; i++) {
                                if (year.charAt(i) > '9' || year.charAt(i) < '0')
                                    return false;
                            }
                            admin.updateStudent(student);
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }

    @Override
    public Student getStudentById(String id) {
        return admin.selectStuById(id);
    }

    @Override
    public boolean addStudent(Student student) {
        if (student.getId() != null && student.getId().length() > 0 && student.getId().length() <= 20) {
            if (admin.selectStuById(student.getId()) == null) {
                String name = student.getName().trim();
                if (name != null && name.length() <= 20 && name.length() > 0) {
                    String pwd = student.getPwd().trim();
                    if (pwd != null && pwd.length() <= 20 && pwd.length() > 0) {
                        String major = student.getMajor().trim();
                        if (major != null && major.length() <= 100 && major.length() > 0) {
                            String year = student.getYear();
                            if (year.length() == 4) {
                                for (int i = 0; i < 4; i++) {
                                    if (year.charAt(i) > '9' || year.charAt(i) < '0')
                                        return false;
                                }
                                if(Integer.parseInt(year)>=1900) {
                                    admin.addStudent(student);
                                    return true;
                                }
                            }

                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void delStudent(String id) {
        admin.delStudent(id);
        admin.delStudyInfoBySId(id);
    }

    @Override
    public boolean addCourse(Course course) {
        String name=course.getName();
        if(name.length()>0&&name.length()<=100){
            String time=course.getTime();
            if(time.length()>0&&time.length()<=20){
                for (int i = 0; i < time.length(); i++) {
                    if (time.charAt(i) > '9' || time.charAt(i) < '0')
                        if(time.charAt(i)!='('&&time.charAt(i)!=')'&&time.charAt(i)!='/'){
                            return false;
                        }
                }
                String belong=course.getBelong();
                if(belong.length()>0&&belong.length()<=100){
                    String detail=course.getDetail();
                    if(detail.length()>0&&detail.length()<=200){
                        String place=course.getPlace();
                        if(place.length()>0&&place.length()<=30){
                            admin.addCourse(course);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void delCourse(Integer id) {
        admin.delCourse(id);
        admin.delStudyInfoByCId(id);
    }

    @Override
    public Course getCourseById(Integer id) {
        return clzDao.selectById(id);
    }

    @Override
    public boolean updateCourse(Course course) {
        Integer id=course.getId();
        if(id!=null||id>0) {
            String name = course.getName();
            if (name.length() > 0 && name.length() <= 100) {
                String time = course.getTime();
                if (time.length() > 0 && time.length() <= 20) {
                    for (int i = 0; i < time.length(); i++) {
                        if (time.charAt(i) > '9' || time.charAt(i) < '0')
                            if (time.charAt(i) != '(' && time.charAt(i) != ')' && time.charAt(i) != '/') {
                                return false;
                            }
                    }
                    String belong = course.getBelong();
                    if (belong.length() > 0 && belong.length() <= 100) {
                        String detail = course.getDetail();
                        if (detail.length() > 0 && detail.length() <= 200) {
                            String place = course.getPlace();
                            if (place.length() > 0 && place.length() <= 30) {
                                if(course.getAmount()>=course.getSelected()) {
                                    clzDao.update(course);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<Study> getAllStudyInfo() {
        return admin .selectAllStudyInfo();
    }



    @Override
    public void addStudyInfo(Study studyInfo) {
        admin.addStudyInfo(studyInfo);
    }

    @Override
    public void delStudyInfo(Integer id) {
        admin.delStudyInfo(id);
    }

    @Override
    public Study  getStudyById(Integer id) {

        return admin.selectById(id);
    }
}
