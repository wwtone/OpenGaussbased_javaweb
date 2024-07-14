package com.DaoImpl;

import com.Beans.Student;
import com.Beans.Teacher;
import com.Dao.ImportDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ImportDaoImpl implements ImportDao {

    private static final String INSERT_STUDENT_SQL =
            "INSERT INTO WuwtStudents (WuwtstudentID, WuwtstudentName, Wuwtgender, Wuwtage, Wuwthometown) VALUES (?, ?, ?, ?, ?)";
    private static final String INSERT_TEACHER_SQL =
            "INSERT INTO WuwtTeachers (WuwtteacherID, WuwtteacherName, WuwtteacherGender, WuwtteacherAge, Wuwttitle, WuwtcontactNumber) VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public void importStudents(List<Student> students) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_STUDENT_SQL)) {

            for (Student student : students) {
                pstmt.setString(1, student.getStudentID());
                pstmt.setString(2, student.getStudentName());
                pstmt.setString(3, student.getGender());
                pstmt.setInt(4, student.getAge());
                pstmt.setString(5, student.getHometown());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            System.out.println("Import students successful.");
        } catch (SQLException e) {
            System.err.println("Error importing students: " + e.getMessage());
        }
    }

    @Override
    public void importTeachers(List<Teacher> teachers) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_TEACHER_SQL)) {

            for (Teacher teacher : teachers) {
                pstmt.setString(1, teacher.getTeacherID());
                pstmt.setString(2, teacher.getTeacherName());
                pstmt.setString(3, teacher.getTeacherGender());
                pstmt.setInt(4, teacher.getTeacherAge());
                pstmt.setString(5, teacher.getTitle());
                pstmt.setString(6, teacher.getContactNumber());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            System.out.println("Import teachers successful.");
        } catch (SQLException e) {
            System.err.println("Error importing teachers: " + e.getMessage());
        }
    }


}
