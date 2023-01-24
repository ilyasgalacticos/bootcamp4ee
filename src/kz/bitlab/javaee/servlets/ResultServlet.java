package kz.bitlab.javaee.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/result")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("user_name");
        String age = request.getParameter("user_age");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<h1>YOUR NAME IS " + name+" AND YOUR ARE " + age + " YEARS OLD!</h1>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("user_name");
        String age = request.getParameter("user_age");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<h1>YOUR NAME IS " + name+" AND YOUR ARE " + age + " YEARS OLD!</h1>");

    }
}