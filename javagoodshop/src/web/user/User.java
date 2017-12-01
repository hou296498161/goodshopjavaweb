package web.user;

import dao.user.UserExist;
import dao.user.UserLogin;
import dao.user.UserRegister;

import java.sql.SQLException;

public class User {

    /**
     * 用户登录
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

    /**
     * 注册用户
     * @param name
     * @param password
     * @param telephone
     * @return
     * @throws SQLException
     */
    public boolean register(String name,String password,String telephone) throws SQLException {
        UserRegister userRegister=new UserRegister();
        if (userRegister.register(name,password,telephone)){
            return true;
        }
        return false;
    }

    /**
     * 判断用户是否存在
     * @param name
     * @return
     */
    public boolean isExist(String name) throws SQLException {
        UserExist userExist=new UserExist();
        if (userExist.Exist(name)) {
            return true;
        }
        return false;
    }

}
