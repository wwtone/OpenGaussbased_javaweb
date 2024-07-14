package com.DaoImpl;

import com.Beans.Student;
import com.Dao.DaoException;
import com.Dao.StudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public int sumstudent() throws DaoException {
        String sql = "SELECT COUNT(*) FROM WuwtStudents";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            return 0;
        }
        return 0;
    }

    @Override
    public ArrayList<Student> findStudent(String s) throws DaoException {
        String sql = "SELECT * FROM WuwtStudents WHERE WuwtclassID = ?";
        ArrayList<Student> students = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getString("WuwtstudentID"));
                student.setStudentName(rs.getString("WuwtstudentName"));
                student.setGender(rs.getString("Wuwtgender"));
                student.setAge(rs.getInt("Wuwtage"));
                student.setEarnedCredits(rs.getInt("WuwtearnedCredits"));
                student.setHometown(rs.getString("Wuwthometown"));
                students.add(student);
            }
        } catch (SQLException e) {
            return null;
        }
        return students;
    }

    public ArrayList<Student> getStudentsByNameAndID(String studentName, String studentID) throws DaoException {
        StringBuilder sql = new StringBuilder("SELECT * FROM WuwtStudents WHERE 1=1");

        if (studentName != null && !studentName.trim().isEmpty()) {
            sql.append(" AND WuwtstudentName LIKE ?");
        }
        if (studentID != null && !studentID.trim().isEmpty()) {
            sql.append(" AND WuwtstudentID LIKE ?");
        }

        ArrayList<Student> students = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            int index = 1;
            if (studentName != null && !studentName.trim().isEmpty()) {
                pstmt.setString(index++, "%" + studentName + "%");
            }
            if (studentID != null && !studentID.trim().isEmpty()) {
                pstmt.setString(index++, "%" + studentID + "%");
            }

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getString("WuwtstudentID"));
                student.setStudentName(rs.getString("WuwtstudentName"));
                student.setGender(rs.getString("Wuwtgender"));
                student.setAge(rs.getInt("Wuwtage"));
                student.setHometown(rs.getString("Wuwthometown"));
                student.setClassID(rs.getString("WuwtclassID"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("Error querying students by name and ID");
        }
        return students;
    }

    @Override
    public boolean updateStudent(Student student) throws DaoException {
        String sql = "UPDATE WuwtStudents SET WuwtstudentName = ?, Wuwtgender = ?, Wuwtage = ?, WuwtearnedCredits = ?, Wuwthometown = ?, WuwtclassID = ? WHERE WuwtstudentID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getStudentName());
            stmt.setString(2, student.getGender());
            stmt.setInt(3, student.getAge());
            stmt.setInt(4, student.getEarnedCredits());
            stmt.setString(5, student.getHometown());
            stmt.setString(6, student.getClassID());
            stmt.setString(7, student.getStudentID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean deleteStudent(String s) throws DaoException {
        String sql = "DELETE FROM WuwtStudents WHERE WuwtstudentID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean addStudent(Student student) throws Exception {
        String sql = "INSERT INTO WuwtStudents (WuwtclassID, WuwtstudentID, WuwtstudentName, Wuwtgender, Wuwtage, WuwtearnedCredits, Wuwthometown) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getClassID());
            stmt.setString(2, student.getStudentID());
            stmt.setString(3, student.getStudentName());
            stmt.setString(4, student.getGender());
            stmt.setInt(5, student.getAge());
            stmt.setInt(6, student.getEarnedCredits());
            stmt.setString(7, student.getHometown());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Student> getStudent(String studentNum, String studentName) {
        String sql = "SELECT * FROM WuwtStudents WHERE WuwtstudentID = ? AND WuwtstudentName = ?";
        List<Student> students = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentNum);
            stmt.setString(2, studentName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getString("WuwtstudentID"));
                student.setStudentName(rs.getString("WuwtstudentName"));
                student.setGender(rs.getString("Wuwtgender"));
                student.setAge(rs.getInt("Wuwtage"));
                student.setEarnedCredits(rs.getInt("WuwtearnedCredits"));
                student.setHometown(rs.getString("Wuwthometown"));
                students.add(student);
            }
        } catch (SQLException e) {
            return null;
        }
        return students;
    }

    @Override
    public String getStudentClass(String stuNum) throws DaoException {
        String sql = "SELECT WuwtclassID FROM WuwtStudents WHERE WuwtstudentID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, stuNum);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("WuwtclassID");
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }
}
