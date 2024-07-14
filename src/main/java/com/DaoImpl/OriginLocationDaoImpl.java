package com.DaoImpl;

import com.Beans.OriginLocation;
import com.Dao.OriginLocationDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OriginLocationDaoImpl implements OriginLocationDao {

    @Override
    public List<OriginLocation> getOriginLocationCounts() {
        String sql = "SELECT Wuwthometown, COUNT(*) as count FROM WuwtStudents GROUP BY Wuwthometown";
        List<OriginLocation> locations = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                OriginLocation location = new OriginLocation();
                location.setHometown(rs.getString("Wuwthometown"));
                location.setCount(rs.getInt("count"));
                locations.add(location);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locations;
    }
}
