package uitls;

import java.sql.*;

public class JDBCUtil {
    public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/goodshop";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    // 加载数据库
    static {
        try {
            Class.forName(DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }

    // 获得连接
    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


    public static void closeConn(Connection conn, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();

        }
        if (preparedStatement != null) {
            preparedStatement.clearParameters();
        }
        if (null != conn) {

            conn.close();

        }
    }
}
