package com.Dao;

import com.Beans.BasicInfo;

import java.sql.SQLException;

public interface BasicInfoDao extends BaseDao{
    BasicInfo getBasicInfo(String studentID) throws DaoException;
    boolean addBasicInfo(BasicInfo basicInfo) throws DaoException;
    boolean deleteBasicInfo(String studentID) throws DaoException;
    boolean updateBasicInfo(BasicInfo updatedInfo) throws DaoException, SQLException;
}
