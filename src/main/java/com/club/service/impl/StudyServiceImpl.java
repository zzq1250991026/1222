package com.club.service.impl;

import com.club.bean.Study;
import com.club.dao.StudyDao;
import com.club.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudyServiceImpl implements StudyService {
    @Autowired
    private StudyDao studyInfoDao;

    @Override
    public List<Study> getAllClzByStuId(String stuId) {
        return studyInfoDao.selectByStuId(stuId);
    }

    @Override
    public List<Study> getAllStuByClzId(Integer clzId) {
        return studyInfoDao.selectByClzId(clzId);
    }

    @Override
    public void delCourse(String stuId, Integer clzId) {
        studyInfoDao.delete(stuId,clzId);
    }
}
