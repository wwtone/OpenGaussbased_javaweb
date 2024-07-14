package com.DaoImpl;

import com.Beans.StudentSearchScore;
import com.Dao.StudentSearchScoreDAO;
import com.Dao.BaseDao; // Ensure BaseDao interface is imported

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentSearchScoreDAOImpl implements StudentSearchScoreDAO, BaseDao {
    @Override
    public List<StudentSearchScore> getStudentScores(String semester, String courseId, String courseName, String studentId, String studentName) {
        List<StudentSearchScore> studentScoreList = new ArrayList<>();
        String sql = "SELECT Wuwtsemester, WuwtcourseID, WuwtcourseName, WuwtstudentID, WuwtstudentName, WuwtcourseCredits, Wuwtscore FROM Wuwtstudent_course_scores WHERE 1=1";

        List<String> parameters = new ArrayList<>();

        if (semester != null && !semester.isEmpty()) {
            sql += " AND Wuwtsemester = ?";
            parameters.add(semester);
        }
        if (courseId != null && !courseId.isEmpty()) {
            sql += " AND WuwtcourseID = ?";
            parameters.add(courseId);
        }
        if (courseName != null && !courseName.isEmpty()) {
            sql += " AND WuwtcourseName LIKE ?";
            parameters.add("%" + courseName + "%");
        }
        if (studentId != null && !studentId.isEmpty()) {
            sql += " AND WuwtstudentID = ?";
            parameters.add(studentId);
        }
        if (studentName != null && !studentName.isEmpty()) {
            sql += " AND WuwtstudentName LIKE ?";
            parameters.add("%" + studentName + "%");
        }

        System.out.println("Generated SQL Query: " + sql);
        System.out.println("Parameters: " + parameters);

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (int i = 0; i < parameters.size(); i++) {
                statement.setString(i + 1, parameters.get(i));
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    StudentSearchScore stuSearchScore = new StudentSearchScore();
                    stuSearchScore.setSemester(resultSet.getString("Wuwtsemester"));
                    stuSearchScore.setCourseID(resultSet.getString("WuwtcourseID"));
                    stuSearchScore.setCourseName(resultSet.getString("WuwtcourseName"));
                    stuSearchScore.setStudentID(resultSet.getString("WuwtstudentID"));
                    stuSearchScore.setStudentName(resultSet.getString("WuwtstudentName"));
                    stuSearchScore.setCourseCredits(resultSet.getInt("WuwtcourseCredits"));
                    stuSearchScore.setScore(resultSet.getInt("Wuwtscore"));
                    studentScoreList.add(stuSearchScore);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger for better practice
        }
        return studentScoreList;
    }
}
