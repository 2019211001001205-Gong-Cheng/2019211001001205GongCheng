package com.gongcheng.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {

    String name="Gong Cheng";
    String id="2019211001001205";
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter writer = response.getWriter();

        Date date=new Date();
        writer.println("Name: "+name);
        writer.println("Id: "+id);
        writer.println("Date and Time: "+date.toString());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
