package com.Dao;

import com.Dao.BaseDao;
import com.Beans.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TeacherDao extends BaseDao{
    //统计教师总数
    public int sumteacher() throws DaoException;
    //所有教师
    public ArrayList<Teacher> findAllteacher() throws  DaoException;
    //修改教师信息
    public boolean updateTeacher(Teacher teacher)throws DaoException;
    //删除教师信息
    public boolean deleteTeacher(String s)throws DaoException;
    //添加教师信息
    public boolean addteacher(Teacher teacher)throws DaoException, SQLException;
    public List<Teacher> getTeacher(String teacherNum, String teacherName);

}
