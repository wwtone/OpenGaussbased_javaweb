package com.Dao;

import com.Beans.UpdateScore;
import java.util.List;

public interface UpdateScoreDAO {
    List<UpdateScore> getUpdateScores(String teacherId, String semester, String courseId, String studentId, String studentName);
    List<UpdateScore> findScores(String teacherId, String semester, String courseId);

    boolean updateScore(UpdateScore updateScore);
}
