package com.gongcheng.week5.demo;

import com.gongcheng.dao.UserDao;
import com.gongcheng.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.applet.Applet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();

        con=(Connection)getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        UserDao userDao=new UserDao();

        try {
            User user = userDao.findByUsernamePassword(con,username,password);
            if (user!=null){
                //valid login
                //week8 code - demo - use cookie for session
                //create cookie

                //step 1:create an object of cookie class
//                Cookie c = new Cookie("sessionid",""+user.getId());//sesionid = user-id
               //step 2：set age of cookie
//                c.setMaxAge(10*60);//in sec-10 min - 7 days - 7*24*60*60
                //step3:add cookie into response
//                resp.addCookie(c);
                String rememberMe = req.getParameter("rememberMe");
                if (rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernameCookie = new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe",rememberMe);

                    usernameCookie.setMaxAge(5);//5 sec - test --- 15 days
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    resp.addCookie(usernameCookie);
                    resp.addCookie(passwordCookie);
                    resp.addCookie(rememberMeCookie);

                }

                HttpSession session=req.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);

                session.setAttribute("user",user);
                req.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(req,resp);
            }else {
                req.setAttribute("message","username or Password Error!!!");
                req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
//catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }
}
