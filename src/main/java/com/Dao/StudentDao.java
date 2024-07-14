package com.Dao;

import com.Dao.BaseDao;
import com.Beans.Student;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

public interface StudentDao extends BaseDao {
    //统计学生总数
    public int sumstudent() throws DaoException;

    //按照班级列出学生
    public ArrayList<Student> findStudent(String s) throws DaoException;

    public ArrayList<Student> getStudentsByNameAndID(String studentName, String studentID) throws DaoException;

    //修改学生信息
    public boolean updateStudent(Student student) throws DaoException;

    //删除学生信息
    public boolean deleteStudent(String s) throws DaoException;

    //添加学生信息
    public boolean addStudent(Student student) throws Exception;


    public List<Student> getStudent(String studentNum, String studentName);

    public String getStudentClass(String stuNum) throws DaoException;

}
