package com.Dao;

import com.Beans.Score;

import java.sql.SQLException;
import java.util.List;

public interface ScoreDao extends BaseDao{
    public List<Score> getRankedScores(String semester, String courseID, String classID) throws SQLException;
}
