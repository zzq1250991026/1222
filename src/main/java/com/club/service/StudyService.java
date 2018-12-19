package com.club.service;

import com.club.bean.Study;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudyService {

     List<Study> getAllClzByStuId(String stuId);

    List<Study> getAllStuByClzId(Integer clzId);

    void delCourse(String stuId,Integer clzId);
}
