package com.gongcheng.controller;

import com.gongcheng.dao.UserDao;
import com.gongcheng.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.zip.Inflater;
import java.sql.Date;


@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 1: forward to WEB-INF/views/updateUser.jsp
        //TODO 2:create one jsp page - update User
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO 1:get all (6) request parameters
        //TODO 2:create on object of User Model
        //TODO 3:set all 6 request parameters values into User model - setXXX()
        //TODO 4:create an object of UserDao
        //TODO 5:Call updateUser() in UserDao
        //TODO 6:forward to WEB-INF/views/userInfo.jsp

        int id = Integer.valueOf(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        java.util.Date birth = Date.valueOf(request.getParameter("birth"));
        

            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setGender(gender);
            user.setBirthdate(birth);

            UserDao userDao = new UserDao();
            try {
                userDao.updateUser((Connection) getServletContext().getAttribute("con"), user);
                user = userDao.findById((Connection) getServletContext().getAttribute("con"),id);
            } catch (SQLException e) {
                System.out.println(e);
            }
        HttpSession session = request.getSession();
            session.setAttribute("user",user);
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
        }
}
