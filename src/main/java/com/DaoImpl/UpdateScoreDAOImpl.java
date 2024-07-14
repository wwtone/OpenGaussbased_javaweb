package com.DaoImpl;

import com.Beans.UpdateScore;
import com.Dao.BaseDao;
import com.Dao.UpdateScoreDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateScoreDAOImpl implements UpdateScoreDAO, BaseDao {
    @Override
    public List<UpdateScore> getUpdateScores(String teacherId, String semester, String courseId, String studentId, String studentName) {
        List<UpdateScore> updateScoreList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT WuwtteacherID, WuwtstudentID, WuwtstudentName, WuwtcourseID, WuwtcourseName, Wuwtsemester, Wuwtscore FROM Wuwtupdatescore WHERE 1=1");

        List<String> parameters = new ArrayList<>();

        if (teacherId != null && !teacherId.isEmpty()) {
            sql.append(" AND WuwtteacherID = ?");
            parameters.add(teacherId);
        }
        if (semester != null && !semester.isEmpty()) {
            sql.append(" AND Wuwtsemester = ?");
            parameters.add(semester);
        }
        if (courseId != null && !courseId.isEmpty()) {
            sql.append(" AND WuwtcourseID = ?");
            parameters.add(courseId);
        }
        if (studentId != null && !studentId.isEmpty()) {
            sql.append(" AND WuwtstudentID = ?");
            parameters.add(studentId);
        }
        if (studentName != null && !studentName.isEmpty()) {
            sql.append(" AND WuwtstudentName LIKE ?");
            parameters.add("%" + studentName + "%");
        }

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql.toString())) {

            for (int i = 0; i < parameters.size(); i++) {
                statement.setString(i + 1, parameters.get(i));
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    UpdateScore updateScore = new UpdateScore();
                    updateScore.setTeacherId(resultSet.getString("WuwtteacherID"));
                    updateScore.setStudentId(resultSet.getString("WuwtstudentID"));
                    updateScore.setStudentName(resultSet.getString("WuwtstudentName"));
                    updateScore.setCourseId(resultSet.getString("WuwtcourseID"));
                    updateScore.setCourseName(resultSet.getString("WuwtcourseName"));
                    updateScore.setSemester(resultSet.getString("Wuwtsemester"));
                    updateScore.setScore(resultSet.getInt("Wuwtscore"));
                    updateScoreList.add(updateScore);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateScoreList;
    }

    @Override
    public List<UpdateScore> findScores(String teacherId, String semester, String courseId) {
        Connection connection = getConnection();
        List<UpdateScore> scores = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM Wuwtupdatescore WHERE 1=1");

        // Add conditions dynamically based on input
        if (teacherId != null && !teacherId.isEmpty()) {
            sql.append(" AND WuwtteacherID = ?");
        }
        if (semester != null && !semester.isEmpty()) {
            sql.append(" AND Wuwtsemester = ?");
        }
        if (courseId != null && !courseId.isEmpty()) {
            sql.append(" AND WuwtcourseID = ?");
        }

        try (PreparedStatement ps = connection.prepareStatement(sql.toString())) {
            int paramIndex = 1;
            if (teacherId != null && !teacherId.isEmpty()) {
                ps.setString(paramIndex++, teacherId);
            }
            if (semester != null && !semester.isEmpty()) {
                ps.setString(paramIndex++, semester);
            }
            if (courseId != null && !courseId.isEmpty()) {
                ps.setString(paramIndex++, courseId);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UpdateScore score = new UpdateScore();
                score.setTeacherId(rs.getString("WuwtteacherID"));
                score.setStudentId(rs.getString("WuwtstudentID"));
                score.setStudentName(rs.getString("WuwtstudentName"));
                score.setCourseId(rs.getString("WuwtcourseID"));
                score.setCourseName(rs.getString("WuwtcourseName"));
                score.setSemester(rs.getString("Wuwtsemester"));
                score.setScore(rs.getInt("Wuwtscore"));
                scores.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }

    public boolean updateScore(UpdateScore updateScore) {
        String sql = "{ CALL Wuwt.fn_credit(?, ?, ?, ?, ?, 'UPDATE') }";
        try (Connection connection = getConnection();
             CallableStatement statement = connection.prepareCall(sql)) {
            statement.setString(1, updateScore.getStudentId());
            statement.setString(2, updateScore.getCourseId());
            statement.setString(3, updateScore.getSemester());
            statement.setInt(4, updateScore.getScore());
            statement.setDouble(5, getCourseCredits(updateScore.getCourseId()));

            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private double getCourseCredits(String courseId) {
        // 实现这个方法来从数据库中获取课程学分
        // 例如：
        String sql = "SELECT WuwtcourseCredits FROM Wuwtcourses WHERE WuwtcourseID = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, courseId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("WuwtcourseCredits");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0; // 如果没有找到，则返回默认值
    }
}
