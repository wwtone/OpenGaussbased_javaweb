package com.Dao;


import com.Beans.StudentSearchScore;
import java.util.List;


public interface StudentSearchScoreDAO extends BaseDao{
    List<StudentSearchScore> getStudentScores(String semester, String courseId, String courseName, String studentId, String name);
}
