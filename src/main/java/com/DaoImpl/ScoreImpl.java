package com.DaoImpl;

import com.Beans.Score;
import com.Dao.ScoreDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreImpl implements ScoreDao {

    @Override
    public List<Score> getRankedScores(String semester, String courseID, String classID) throws SQLException {
        Connection conn = getConnection();
        List<Score> scores = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM wuwtfn_rank(");

        // Append placeholders for parameters
        if (semester != null) {
            sql.append("?, ");
        } else {
            sql.append("NULL, ");
        }
        if (courseID != null) {
            sql.append("?, ");
        } else {
            sql.append("NULL, ");
        }
        if (classID != null) {
            sql.append("?");
        } else {
            sql.append("NULL");
        }
        sql.append(")");

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            int paramIndex = 1;
            if (semester != null) {
                pstmt.setString(paramIndex++, semester);
            }
            if (courseID != null) {
                pstmt.setString(paramIndex++, courseID);
            }
            if (classID != null) {
                pstmt.setString(paramIndex++, classID);
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Score score = new Score();
                    score.setStudentID(rs.getString("WuwtstudentID"));
                    score.setStudentName(rs.getString("WuwtstudentName"));
                    score.setCourseName(rs.getString("WuwtcourseName"));
                    score.setSemester(semester);
                    score.setScore(rs.getDouble("Wuwtscore"));
                    score.setScoreRank(rs.getInt("WuwtscoreRank"));
                    scores.add(score);
                }
            }
        }
        return scores;
    }
}
