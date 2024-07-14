package com.DaoImpl;

import com.Beans.ClassSchedule;
import com.Dao.BaseDao;
import com.Dao.StudentScheduleDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentScheduleDaoImpl implements StudentScheduleDao, BaseDao {
    @Override
    public List<ClassSchedule> getClassSchedule(String academicYear, String semester, String studentId, String studentName) {
        List<ClassSchedule> classScheduleList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            StringBuilder sql = new StringBuilder("SELECT WuwtcourseID, WuwtcourseName, WuwtteacherName, Wuwtsemester, credit, courseHours, examForm, WuwtTeachCourse.WuwtclassID, WuwtclassName " +
                    "FROM WuwtTeachCourse JOIN WuwtStudents ON WuwtTeachCourse.WuwtclassID = WuwtStudents.WuwtclassID WHERE 1=1");

            if (academicYear != null && !academicYear.isEmpty() && semester != null && !semester.isEmpty()) {
                sql.append(" AND Wuwtsemester = ?");
            }
            if (studentId != null && !studentId.isEmpty()) {
                sql.append(" AND WuwtstudentID = ?");
            }
            if (studentName != null && !studentName.isEmpty()) {
                sql.append(" AND WuwtstudentName = ?");
            }

            PreparedStatement statement = connection.prepareStatement(sql.toString());
            int index = 1;
            if (academicYear != null && !academicYear.isEmpty() && semester != null && !semester.isEmpty()) {
                String sem = academicYear + semester;
                statement.setString(index++, sem);
            }
            if (studentId != null && !studentId.isEmpty()) {
                statement.setString(index++, studentId);
            }
            if (studentName != null && !studentName.isEmpty()) {
                statement.setString(index++, studentName);
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClassSchedule classSchedule = new ClassSchedule();
                classSchedule.setCourseID(resultSet.getString("WuwtcourseID"));
                classSchedule.setCourseName(resultSet.getString("WuwtcourseName"));
                classSchedule.setTeacherName(resultSet.getString("WuwtteacherName"));
                classSchedule.setSemester(resultSet.getString("Wuwtsemester"));
                classSchedule.setCredit(resultSet.getInt("credit"));
                classSchedule.setCourseHours(resultSet.getInt("courseHours"));
                classSchedule.setExamForm(resultSet.getString("examForm"));
                classSchedule.setClassID(resultSet.getString("WuwtclassID"));
                classSchedule.setClassName(resultSet.getString("WuwtclassName"));
                classScheduleList.add(classSchedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classScheduleList;
    }
}
