package service.user;

import web.user.User;

import java.io.IOException;
import java.sql.SQLException;

public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String method = request.getParameter("method");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User();
        //用户登录
        if ("1".equals(method)) {
            try {
                if (user.isExist(name)) {
                    if (user.login(name, password)) {
                        response.getWriter().print("登录成功");
                    } else {
                        response.getWriter().print("登录失败");
                    }
                }else {
                    response.getWriter().print("该用户不存在");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //注册用户
        if ("2".equals(method)) {
            String telephone = request.getParameter("telephone");
            try {
                if (user.isExist(name)) {
                    response.getWriter().print("该用户已经存在");
                }else {
                    if (user.register(name, password, telephone)) {
                        response.getWriter().print("注册成功");
                    } else {
                        response.getWriter().print("注册失败");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
