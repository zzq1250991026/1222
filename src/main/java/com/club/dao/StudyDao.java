package com.club.dao;

import com.club.bean.Study;

import java.util.List;
public interface StudyDao {

     List<Study> selectByClzId(Integer clzId);

     List<Study> selectByStuId(String stuId);

     Study check(String stuId,Integer clzId);

     void insert(Study study);

     void delete(String stuId,Integer clzId);

}
