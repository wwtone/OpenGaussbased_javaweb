package com.Dao;

import com.Beans.Student;
import com.Beans.Teacher;

import java.util.List;

public interface ImportDao extends BaseDao{
    void importStudents(List<Student> students);
    void importTeachers(List<Teacher> teachers);
}
