package dao.user;

import uitls.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegister {

    public boolean register(String name,String password,String telephone) throws SQLException {
        Connection conn = JDBCUtil.getConn();
        String sql="insert into user(user_name,user_password,user_telephone) values(?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,telephone);
        int i = preparedStatement.executeUpdate();
        if (i>0){
            return true;
        }
        return false;
    }

}
