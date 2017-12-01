package web.user;

import dao.user.UserLogin;
import dao.user.UserRegister;

import java.sql.SQLException;

public class User {

    /**
     * 判断用户名和密码是否正确
     * @param name
     * @param password
     * @return
     * @throws SQLException
     */
    public boolean login(String name,String password) throws SQLException {

        UserLogin userLogin=new UserLogin();
        if (userLogin.login(name,password)){
            return true;
        }
        return false;

    }
    public boolean register(String name,String password,String telephone) throws SQLException {
        UserRegister userRegister=new UserRegister();
        if (userRegister.register(name,password,telephone)){
            return true;
        }
        return false;
    }
}
