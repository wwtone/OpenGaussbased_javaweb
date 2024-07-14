package com.Dao;

import com.Beans.Major;

import java.util.ArrayList;
import java.util.List;

public interface MajorDao extends BaseDao {
    //统计专业总数
    int summajor() throws DaoException;
    //所有专业列表
    ArrayList<Major> findAllMajor() throws DaoException;
    //根据编号和名称查询专业
    public Major findMajor(String majorID) throws DaoException;
    //修改专业信息
    boolean changeMajor(Major oldMajor, Major newMajor) throws DaoException;
    //删除专业信息
    boolean deleteMajor(String oldMajorID) throws DaoException;
    //添加专业信息
    boolean addMajor(Major major) throws DaoException;
    //查询专业
    List<Major> getMajor(String majorNum, String majorName);
}
