package com.Dao;
import com.Beans.TeacherScoreAvg;

import java.sql.SQLException;
import java.util.List;

public interface ScoreManageDao extends BaseDao{
    List<TeacherScoreAvg> search_course_average(String teaID,String courseID,String time) throws SQLException;

}