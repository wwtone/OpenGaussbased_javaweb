package com.DaoImpl;

import com.Beans.Teacher;
import com.Dao.DaoException;
import com.Dao.TeacherDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    @Override
    public int sumteacher() throws DaoException {
        String sql = "SELECT COUNT(*) FROM WuwtTeachers";
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
    public ArrayList<Teacher> findAllteacher() throws DaoException {
        String sql = "SELECT * FROM WuwtTeachers";
        ArrayList<Teacher> teachers = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherID(rs.getString("WuwtteacherID"));
                teacher.setTeacherName(rs.getString("WuwtteacherName"));
                teacher.setTeacherGender(rs.getString("WuwtteacherGender"));
                teacher.setTeacherAge(rs.getInt("WuwtteacherAge"));
                teacher.setTitle(rs.getString("Wuwttitle"));
                teacher.setContactNumber(rs.getString("WuwtcontactNumber"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            return null;
        }
        return teachers;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) throws DaoException {
        String sql = "UPDATE WuwtTeachers SET WuwtteacherName = ?, WuwtteacherGender = ?, WuwtteacherAge = ?, Wuwttitle = ?, WuwtcontactNumber = ? WHERE WuwtteacherID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, teacher.getTeacherName());
            stmt.setString(2, teacher.getTeacherGender());
            stmt.setInt(3, teacher.getTeacherAge());
            stmt.setString(4, teacher.getTitle());
            stmt.setString(5, teacher.getContactNumber());
            stmt.setString(6, teacher.getTeacherID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean deleteTeacher(String s) throws DaoException {
        String sql = "DELETE FROM WuwtTeachers WHERE WuwtteacherID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean addteacher(Teacher teacher) throws DaoException, SQLException {
        String sql = "INSERT INTO WuwtTeachers (WuwtteacherID, WuwtteacherName, WuwtteacherGender, WuwtteacherAge, Wuwttitle, WuwtcontactNumber) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, teacher.getTeacherID());
            stmt.setString(2, teacher.getTeacherName());
            stmt.setString(3, teacher.getTeacherGender());
            stmt.setInt(4, teacher.getTeacherAge());
            stmt.setString(5, teacher.getTitle());
            stmt.setString(6, teacher.getContactNumber());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Teacher> getTeacher(String teacherNum, String teacherName) {
        StringBuilder sql = new StringBuilder("SELECT * FROM WuwtTeachers WHERE 1=1");

        List<String> parameters = new ArrayList<>();
        if (teacherNum != null && !teacherNum.trim().isEmpty()) {
            sql.append(" AND WuwtteacherID LIKE ?");
            parameters.add("%" + teacherNum + "%");
        }
        if (teacherName != null && !teacherName.trim().isEmpty()) {
            sql.append(" AND WuwtteacherName LIKE ?");
            parameters.add("%" + teacherName + "%");
        }

        List<Teacher> teachers = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            int index = 1;
            for (String param : parameters) {
                stmt.setString(index++, param);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherID(rs.getString("WuwtteacherID"));
                teacher.setTeacherName(rs.getString("WuwtteacherName"));
                teacher.setTeacherGender(rs.getString("WuwtteacherGender"));
                teacher.setTeacherAge(rs.getInt("WuwtteacherAge"));
                teacher.setTitle(rs.getString("Wuwttitle"));
                teacher.setContactNumber(rs.getString("WuwtcontactNumber"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
}
