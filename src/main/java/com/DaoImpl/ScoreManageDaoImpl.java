package com.DaoImpl;

import com.Beans.TeacherScoreAvg;
import com.Dao.ScoreManageDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreManageDaoImpl implements ScoreManageDao {
    @Override
    public List<TeacherScoreAvg> search_course_average(String teaID, String courID, String time) throws SQLException {
        Connection conn = getConnection();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT WuwtteacherID, WuwtcourseID, WuwtcourseName, Wuwtsemester, avg ");
        sql.append("FROM Wuwtteacher_course_average WHERE 1=1 ");

        if (teaID != null && !teaID.isEmpty()) {
            sql.append(" AND WuwtteacherID = ? ");
        }
        if (courID != null && !courID.isEmpty()) {
            sql.append(" AND WuwtcourseID = ? ");
        }
        if (time != null && !time.isEmpty()) {
            sql.append(" AND Wuwtsemester = ? ");
        }

        PreparedStatement stmt = conn.prepareStatement(sql.toString());
        int parameterIndex = 1;

        if (teaID != null && !teaID.isEmpty()) {
            stmt.setString(parameterIndex++, teaID);
        }
        if (courID != null && !courID.isEmpty()) {
            stmt.setString(parameterIndex++, courID);
        }
        if (time != null && !time.isEmpty()) {
            stmt.setString(parameterIndex++, time);
        }

        ResultSet rs = stmt.executeQuery();
        List<TeacherScoreAvg> list = new ArrayList<>();

        while (rs.next()) {
            String tID = rs.getString("WuwtteacherID");
            String cID = rs.getString("WuwtcourseID");
            String cName = rs.getString("WuwtcourseName");
            String semester = rs.getString("Wuwtsemester");
            double avgScore = rs.getDouble("avg");

            TeacherScoreAvg tca = new TeacherScoreAvg(tID, cID, cName, semester, avgScore);
            list.add(tca);
        }
        return list;
    }
}
