package com.Dao;
import com.Beans.teacher_search_score;
import com.Beans.teacher_course_average;

import java.sql.SQLException;
import java.util.List;

public interface Teacher_search extends BaseDao{
    List<teacher_search_score> search_scoreBy_stuID_courID(String teacherID,String stuID, String courID,String time) throws SQLException;

    List<teacher_course_average> search_course_average(String teaID,String courseID,String time) throws SQLException;

}
