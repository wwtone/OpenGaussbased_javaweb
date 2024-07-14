import java.sql.*;

public class ConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.232.135:26000/wwt_db_uni?useUnicode=true&characterEncoding=UTF-8&currentSchema=Wuwt";
        String user = "zjutwwt";
        String password = "Wwt@12345678";

        try {
            // 连接数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection is successful");
            String sql = "SELECT WuwtteacherID, WuwtteacherName, WuwtcourseID, WuwtcourseName, Wuwttitle, Wuwtsemester FROM WuwtTeach WHERE 1=1"  ;
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                System.out.println(rs);
            }


            // 关闭连接

        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
        }
    }
}
