package com.gongcheng.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
       super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");

        try {
            Statement st = con.createStatement();
            String sql = "insert into usertable(username,password,email,gender,birthdate) "+
                    "values('" + username +"','" + password + "','" + email + "','" + gender + "','" + birthdate +"')";
            System.out.println("sql"+sql);

            int n =st.executeUpdate(sql);
            System.out.println("n-->"+n);

            //sql = "select id,username,password,email,gender,birthdate from usertable";
            //ResultSet rs =st.executeQuery(sql);
            //PrintWriter out = response.getWriter();

            response.sendRedirect("login");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }
    @Override
    public void destroy(){

    }
}