package com.DaoImpl;

import com.Beans.TeacherSchedule;
import com.Dao.TeacherScheduleDAO;
import com.Dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherScheduleDAOImpl implements TeacherScheduleDAO, BaseDao {
    @Override
    public List<TeacherSchedule> getTeacherSchedule(String academicYear, String semester, String title, String teacher, String teacherID) {
        List<TeacherSchedule> teacherScheduleList = new ArrayList<>();
        String sql = "SELECT WuwtteacherID, WuwtteacherName, WuwtcourseID, WuwtcourseName, Wuwttitle, Wuwtsemester FROM WuwtTeach WHERE 1=1";

        List<String> parameters = new ArrayList<>();

        if (academicYear != null && !academicYear.isEmpty() && semester != null && !semester.isEmpty()) {
            sql += " AND Wuwtsemester = ?";
            parameters.add(academicYear + semester);
        }
        if (title != null && !title.isEmpty()) {
            sql += " AND Wuwttitle LIKE ?";
            parameters.add("%" + title + "%");
        }
        if (teacher != null && !teacher.isEmpty()) {
            sql += " AND WuwtteacherName LIKE ?";
            parameters.add("%" + teacher + "%");
        }
        if (teacherID != null && !teacherID.isEmpty()) {
            sql += " AND WuwtteacherID = ?";
            parameters.add(teacherID);
        }

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (int i = 0; i < parameters.size(); i++) {
                statement.setString(i + 1, parameters.get(i));
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    TeacherSchedule teacherSchedule = new TeacherSchedule();
                    teacherSchedule.setTeacherID(resultSet.getString("WuwtteacherID"));
                    teacherSchedule.setTeacherName(resultSet.getString("WuwtteacherName"));
                    teacherSchedule.setCourseID(resultSet.getString("WuwtcourseID"));
                    teacherSchedule.setCourseName(resultSet.getString("WuwtcourseName"));
                    teacherSchedule.setTitle(resultSet.getString("Wuwttitle"));
                    teacherSchedule.setSemester(resultSet.getString("Wuwtsemester"));
                    teacherScheduleList.add(teacherSchedule);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger for better practice
        }
        return teacherScheduleList;
    }
}
