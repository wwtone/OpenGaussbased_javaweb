package com.DaoImpl;

import com.Beans.Admin;
import com.Dao.AdminDao;
import com.Dao.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    @Override
    public String judgeAdmin(String pno, String password) throws DaoException {
        String sql = "SELECT * FROM WuwtAdmin_Accounts WHERE WuwtadminName = ? AND WuwtadminPassword = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pno);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("WuwtadminRole");
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }



    @Override
    public void changePassword(String number, String sha256StrJava) {
        String sql = "UPDATE WuwtAdmin_Accounts SET WuwtadminPassword = ? WHERE WuwtadminName = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sha256StrJava);
            stmt.setString(2, number);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
