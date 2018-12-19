package com.club.controller;

import com.alibaba.fastjson.JSON;
import com.club.bean.Course;
import com.club.bean.Student;
import com.club.bean.Study;
import com.club.service.AdminService;
import com.club.service.CourseService;
import com.club.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 *
 * @Author cyan
 * @Date 16/7/5.
 */

@Controller
public class DisplayController {

    @Autowired
    private CourseService clzService;

    @Autowired
    private StudyService studyService;

    @Autowired
    private AdminService adminService;


    @RequestMapping("/index")
    public String displayAll(HttpServletRequest req) {

        List<Course> clzs = clzService.getAllClz();
        req.getSession().setAttribute("clzs", clzs);
        return "index";
    }

    @RequestMapping("/showDetail")
    public String showDetail(@RequestParam String id, HttpServletRequest req) {
        Course course = clzService.getClzById(Integer.parseInt(id));
        req.getSession().setAttribute("course", course);
        return "detail";
    }

    @RequestMapping("/showStudent")
    public String showStudents(HttpServletRequest req) {
        try {
            Integer clzId = Integer.parseInt(req.getParameter("id"));
            List<Study> students = studyService.getAllStuByClzId(clzId);

            req.getSession().setAttribute("students", students);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "404";
        }

        return "stulist";

    }

    @RequestMapping("/showAllClasses")
    public String showAllClzs(HttpServletRequest req) {
        List<Course> courses = clzService.getAllClz();
        req.getSession().setAttribute("courses", courses);
        return "clzList";
    }

    @RequestMapping("/showMyClasses")
    public String showMyClzs(HttpServletRequest req) {
        String id = (String) req.getSession().getAttribute("userId");
        List<Study> studyInfos=null;
        if(id!=null){
            studyInfos = studyService.getAllClzByStuId(id);
        }
        req.getSession().setAttribute("clzs", studyInfos);
        return "myClzs";
    }

    @RequestMapping("/studentManage")
    public String studentManage(HttpServletRequest req){
        if(req.getSession().getAttribute("id")==null){
            return "adminLogin";
        }
        List<Student> students=adminService.getAllStudents();
        req.getSession().setAttribute("students", students);
        return "allStudents";
    }
    @RequestMapping("/Zhuce")
    public String Zhuce(HttpServletResponse req){
        return "ZaddStudent";
    }

    @RequestMapping("/courseManage")
    public String courseManage(HttpServletRequest req){
        if(req.getSession().getAttribute("id")==null){
            return "adminLogin";
        }
        List<Course> courses=adminService.
                getAllCourses();
        req.getSession().setAttribute("courses", courses);
        return "allCourses";
    }

    @RequestMapping("/adminIndex")
    public String showChart(HttpServletRequest req){
        if(req.getSession().getAttribute("id")==null){
            return "adminLogin";
        }
        List<Course> courses=adminService.getAllCourses();
        List<String> listX=new ArrayList<String>();
        List<Integer> listSelected=new ArrayList<Integer>();
        List<Integer> listLeft=new ArrayList<Integer>();
        for(Course course:courses){
            listX.add(course.getName());
            listSelected.add(course.getSelected());
            listLeft.add(course.getAmount()-course.getSelected());
        }

        req.getSession().setAttribute("listX", JSON.toJSONString(listX));
        req.getSession().setAttribute("listSelected", JSON.toJSONString(listSelected));
        req.getSession().setAttribute("listLeft", JSON.toJSONString(listLeft));
        return "admin";
    }

    @RequestMapping("/404")
    public String pageNotFount(){
        return "404";
    }

}
