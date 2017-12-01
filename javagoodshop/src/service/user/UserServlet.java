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
        if ("1".equals(method)) {
            try {
                if (user.login(name, password)) {
                    response.getWriter().print("登录成功");
                } else {
                    response.getWriter().print("登录失败");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if ("2".equals(method)) {
            String telephone = request.getParameter("telephone");
            try {
                if (user.register(name, password, telephone)) {
                    response.getWriter().print("注册成功");
                } else {
                    response.getWriter().print("注册失败");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
