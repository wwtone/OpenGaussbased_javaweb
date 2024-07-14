package com.DaoImpl;

import com.Beans.BasicInfo;
import com.Dao.BasicInfoDao;
import com.Dao.DaoException;

import java.sql.*;

public class BasicInfoImpl implements BasicInfoDao {

    @Override
    public BasicInfo getBasicInfo(String studentID) throws DaoException {
        String sql = "SELECT * FROM WuwtBasicInfo WHERE WuwtstudentID = ?";
        BasicInfo basicInfo = new BasicInfo();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                basicInfo.setStudentID(rs.getString("WuwtstudentID"));
                basicInfo.setNamePY(rs.getString("WuwtnamePY"));
                basicInfo.setName(rs.getString("Wuwtname"));
                basicInfo.setGender(rs.getString("Wuwtgender"));
                basicInfo.setNation(rs.getString("Wuwtnation"));
                basicInfo.setBirthDate(rs.getDate("WuwtbirthDate"));
                basicInfo.setNativePlace(rs.getString("WuwtnativePlace"));
                basicInfo.setPoliticalStatus(rs.getString("WuwtpoliticalStatus"));
                basicInfo.setIDType(rs.getString("WuwtIDType"));
                basicInfo.setIDNumber(rs.getString("WuwtIDNumber"));
            }
        } catch (Exception e) {
            return null;
        }
        return basicInfo;
    }

    @Override
    public boolean addBasicInfo(BasicInfo basicInfo) throws DaoException {
        String sql = "INSERT INTO WuwtBasicInfo (WuwtstudentID, Wuwtname, WuwtnamePY, Wuwtgender, Wuwtnation, WuwtbirthDate, WuwtnativePlace, WuwtpoliticalStatus, WuwtIDType, WuwtIDNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, basicInfo.getStudentID());
            stmt.setString(2, basicInfo.getName());
            stmt.setString(3, basicInfo.getNamePY());
            stmt.setString(4, basicInfo.getGender());
            stmt.setString(5, basicInfo.getNation());
            stmt.setDate(6, basicInfo.getBirthDate() != null ? new java.sql.Date(basicInfo.getBirthDate().getTime()) : null);
            stmt.setString(7, basicInfo.getNativePlace());
            stmt.setString(8, basicInfo.getPoliticalStatus());
            stmt.setString(9, basicInfo.getIDType());
            stmt.setString(10, basicInfo.getIDNumber());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteBasicInfo(String studentID) throws DaoException {
        String sql = "DELETE FROM WuwtBasicInfo WHERE WuwtstudentID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentID);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateBasicInfo(BasicInfo updatedInfo) throws SQLException, SQLException {
        String sql = "UPDATE WuwtBasicInfo SET Wuwtname = ?, WuwtnamePY = ?, Wuwtgender = ?, Wuwtnation = ?, WuwtbirthDate = ?, WuwtnativePlace = ?, WuwtpoliticalStatus = ?, WuwtIDType = ?, WuwtIDNumber = ? WHERE WuwtstudentID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, updatedInfo.getName());
            stmt.setString(2, updatedInfo.getNamePY());
            stmt.setString(3, updatedInfo.getGender());
            stmt.setString(4, updatedInfo.getNation());
            stmt.setDate(5, updatedInfo.getBirthDate() != null ? new java.sql.Date(updatedInfo.getBirthDate().getTime()) : null);
            stmt.setString(6, updatedInfo.getNativePlace());
            stmt.setString(7, updatedInfo.getPoliticalStatus());
            stmt.setString(8, updatedInfo.getIDType());
            stmt.setString(9, updatedInfo.getIDNumber());
            stmt.setString(10, updatedInfo.getStudentID());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }
}
