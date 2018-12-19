package com.club.controller;

import com.club.bean.Student;
import com.club.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class Test {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/club")
    public ModelAndView test(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mv=new  ModelAndView();
        Student student=studentService.selectStudentById("2");
        List<Student> students=studentService.selectStudentByRole(3);
        mv.addObject("student",student);
        mv.addObject("students",students);
        mv.setViewName("test1");
        return mv;
    }
}
