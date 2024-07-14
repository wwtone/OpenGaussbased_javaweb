package com.DaoImpl;

import com.Beans.Major;
import com.Dao.DaoException;
import com.Dao.MajorDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MajorDaoImpl implements MajorDao {
    public int summajor() throws DaoException {
        String sql = "SELECT COUNT(WuwtmajorID) AS sum FROM WuwtMajors";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) return rst.getInt("sum");
            else return 0;
        } catch (SQLException se) {
            return 0;
        }
    }

    public ArrayList<Major> findAllMajor() throws DaoException {
        ArrayList<Major> custList = new ArrayList<>();
        String sql = "SELECT * FROM WuwtMajors";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rst = pstmt.executeQuery()) {
            while (rst.next()) {
                Major major = new Major();
                major.setMajorID(rst.getString("WuwtmajorID"));
                major.setMajorName(rst.getString("WuwtmajorName"));
                custList.add(major);
            }
            return custList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Major findMajor(String majorID) throws DaoException {
        String sql = "SELECT * FROM WuwtMajors WHERE WuwtmajorID = ?";
        Major major = new Major();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, majorID);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                major.setMajorID(rst.getString("WuwtmajorID"));
                major.setMajorName(rst.getString("WuwtmajorName"));
            }
        } catch (SQLException se) {
            return null;
        }
        return major;
    }

    public boolean changeMajor(Major oldMajor, Major newMajor) throws DaoException {
        String sql = "UPDATE WuwtMajors SET WuwtmajorID = ?, WuwtmajorName = ? WHERE WuwtmajorID = ? AND WuwtmajorName = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newMajor.getMajorID());
            pstmt.setString(2, newMajor.getMajorName());
            pstmt.setString(3, oldMajor.getMajorID());
            pstmt.setString(4, oldMajor.getMajorName());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMajor(String oldMajorID) throws DaoException {
        String sql = "DELETE FROM WuwtMajors WHERE WuwtmajorID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, oldMajorID);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addMajor(Major major) throws DaoException {
        String sql = "INSERT INTO WuwtMajors VALUES(?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, major.getMajorID());
            pstmt.setString(2, major.getMajorName());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Major> getMajor(String majorNum, String majorName) {
        List<Major> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM WuwtMajors WHERE 1=1");

        if (majorNum != null && !majorNum.isEmpty()) {
            sql.append(" AND WuwtmajorID = ?");
        }
        if (majorName != null && !majorName.isEmpty()) {
            sql.append(" AND WuwtmajorName = ?");
        }

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            int index = 1;
            if (majorNum != null && !majorNum.isEmpty()) {
                pstmt.setString(index++, majorNum);
            }
            if (majorName != null && !majorName.isEmpty()) {
                pstmt.setString(index++, majorName);
            }
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                Major major = new Major(rst.getString("WuwtmajorID"), rst.getString("WuwtmajorName"));
                list.add(major);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
        return list;
    }
}
