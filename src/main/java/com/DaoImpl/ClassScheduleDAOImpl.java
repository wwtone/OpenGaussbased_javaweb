package com.DaoImpl;

import com.Beans.ClassSchedule;
import com.Dao.BaseDao;
import com.Dao.ClassScheduleDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClassScheduleDAOImpl implements ClassScheduleDAO, BaseDao {
    @Override
    public List<ClassSchedule> getClassSchedule(String academicYear, String semester, String classId, String className) {
        List<ClassSchedule> classScheduleList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            StringBuilder sql = new StringBuilder("SELECT WuwtcourseID, WuwtcourseName, WuwtteacherName, Wuwtsemester, credit, courseHours, examForm, WuwtclassID, WuwtclassName FROM WuwtTeachCourse WHERE 1=1");

            if (academicYear != null && !academicYear.isEmpty() && semester != null && !semester.isEmpty()) {
                sql.append(" AND Wuwtsemester = ?");
            }
            if (classId != null && !classId.isEmpty()) {
                sql.append(" AND WuwtclassID = ?");
            }
            if (className != null && !className.isEmpty()) {
                sql.append(" AND WuwtclassName = ? ");

            }
            System.out.println(sql);
            PreparedStatement statement = connection.prepareStatement(sql.toString());
            int index = 1;
            if (academicYear != null && !academicYear.isEmpty() && semester != null && !semester.isEmpty()) {
                String sem = academicYear + semester;
                statement.setString(index++, sem);
            }
            if (classId != null && !classId.isEmpty()) {
                statement.setString(index++, classId);
            }
            if (className != null && !className.isEmpty()) {
                statement.setString(index++, className);
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
