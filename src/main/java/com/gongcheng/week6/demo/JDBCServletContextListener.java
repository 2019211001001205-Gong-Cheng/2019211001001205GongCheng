package com.gongcheng.week6.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@WebListener
public class JDBCServletContextListener implements ServletContextListener{
   @Override
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */
        ServletContext context = sce.getServletContext();
        String driver = context.getInitParameter("driver");
       String url = context.getInitParameter("url");
       String username = context.getInitParameter("username");
       String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("i am in JDBCServletContextListener----->contextInitialized()" + con);

            context.setAttribute("con",con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
        System.out.println("i am in JDBCServletContextListener----->contextDestroyed()");
        sce.getServletContext().removeAttribute("con");
    }

}