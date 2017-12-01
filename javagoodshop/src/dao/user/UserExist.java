package dao.user;

import uitls.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserExist {
    public boolean Exist(String name) throws SQLException {
        Connection conn = JDBCUtil.getConn();
        String sql="select * where user_name=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return true;
        }
        return false;
    }
}
