package dao.user;

import uitls.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogin {
    /**
     * 判断用户名和密码是否正确
     * @param name
     * @param password
     * @return
     * @throws SQLException
     */
    public boolean login(String name,String password) throws SQLException {
        Connection conn = JDBCUtil.getConn();
        String sql="select * from user where user_name=? and user_password=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            JDBCUtil.closeConn(conn,preparedStatement,resultSet);
            return true;
        }
        JDBCUtil.closeConn(conn,preparedStatement,resultSet);
        return false;

    }
}
