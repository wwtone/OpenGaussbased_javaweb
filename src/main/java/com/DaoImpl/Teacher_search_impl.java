package com.DaoImpl;

import com.Beans.teacher_course_average;
import com.Beans.teacher_search_score;
import com.Dao.Teacher_search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teacher_search_impl implements Teacher_search {
    @Override
    public List<teacher_search_score> search_scoreBy_stuID_courID(String teacherID, String stuID, String courID, String time) throws SQLException {
        List<teacher_search_score> list = new ArrayList<>();
        Connection conn = getConnection();

        StringBuilder sql = new StringBuilder("SELECT * FROM Wuwtteacher_search_score WHERE 1=1");

        if (teacherID != null && !teacherID.isEmpty()) {
            sql.append(" AND WuwtteacherID = ?");
        }
        if (courID != null && !courID.isEmpty()) {
            sql.append(" AND WuwtcourseID = ?");
        }
        if (stuID != null && !stuID.isEmpty()) {
            sql.append(" AND WuwtstudentID = ?");
        }
        if (time != null && !time.isEmpty()) {
            sql.append(" AND Wuwtsemester = ?");
        }

        PreparedStatement stmt = conn.prepareStatement(sql.toString());
        int parameterIndex = 1;
        if (teacherID != null && !teacherID.isEmpty()) {
            stmt.setString(parameterIndex++, teacherID);
        }
        if (courID != null && !courID.isEmpty()) {
            stmt.setString(parameterIndex++, courID);
        }
        if (stuID != null && !stuID.isEmpty()) {
            stmt.setString(parameterIndex++, stuID);
        }
        if (time != null && !time.isEmpty()) {
            stmt.setString(parameterIndex++, time);
        }

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String studentID = rs.getString("WuwtstudentID");
            String studentName = rs.getString("WuwtstudentName");
            String courseName = rs.getString("WuwtcourseName");
            String courseID = rs.getString("WuwtcourseID");
            String semester = rs.getString("Wuwtsemester");
            float score = rs.getFloat("Wuwtscore");
            String teaID = rs.getString("WuwtteacherID");
            teacher_search_score tss = new teacher_search_score(studentID, studentName, courseName, courseID, semester, score, teaID);
            list.add(tss);
        }
        return list;
    }

    @Override
    public List<teacher_course_average> search_course_average(String teaID, String courID, String time) throws SQLException {
        Connection conn = getConnection();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT WuwtteacherID, WuwtcourseID, WuwtcourseName, Wuwtsemester, avg ");
        sql.append("FROM Wuwtteacher_course_average WHERE 1=1 ");

        if (teaID != null && !teaID.isEmpty()) {
            sql.append(" AND WuwtteacherID = ? ");
        }
        if (courID != null && !courID.isEmpty()) {
            sql.append(" AND WuwtcourseID = ? ");
        }
        if (time != null && !time.isEmpty()) {
            sql.append(" AND Wuwtsemester = ? ");
        }

        PreparedStatement stmt = conn.prepareStatement(sql.toString());
        int parameterIndex = 1;

        if (teaID != null && !teaID.isEmpty()) {
            stmt.setString(parameterIndex++, teaID);
        }
        if (courID != null && !courID.isEmpty()) {
            stmt.setString(parameterIndex++, courID);
        }
        if (time != null && !time.isEmpty()) {
            stmt.setString(parameterIndex++, time);
        }

        ResultSet rs = stmt.executeQuery();
        List<teacher_course_average> list = new ArrayList<>();

        while (rs.next()) {
            String tID = rs.getString("WuwtteacherID");
            String cID = rs.getString("WuwtcourseID");
            String cName = rs.getString("WuwtcourseName");
            String semester = rs.getString("Wuwtsemester");
            double avgScore = rs.getDouble("avg");

            teacher_course_average tca = new teacher_course_average(tID, cID, cName, semester, avgScore);
            list.add(tca);
        }
        return list;
    }
}
