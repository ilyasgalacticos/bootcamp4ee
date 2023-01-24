package kz.bitlab.javaee.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/home") //endpoint
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h1>COMPLETE GET FORM</h1>");
        out.print("<form action = '/result' method = 'get'>");
        out.print("<span>YOUR NAME : </span><input type = 'text' name = 'user_name'>");
        out.print("<span>YOUR AGE : </span>");
        out.print("<select name = 'user_age'>");
        for(int i=1;i<=120;i++){
            out.print("<option>"+i+"</option>");
        }
        out.print("</select>");
        out.print("<button>SEND</button>");
        out.print("</form>");

        out.print("<br><br><h1>COMPLETE POST FORM</h1>");
        out.print("<form action = '/result' method = 'post'>");
        out.print("<span>YOUR NAME : </span><input type = 'text' name = 'user_name'>");
        out.print("<span>YOUR AGE : </span>");
        out.print("<select name = 'user_age'>");
        for(int i=1;i<=120;i++){
            out.print("<option>"+i+"</option>");
        }
        out.print("</select>");
        out.print("<button>SEND</button>");
        out.print("</form>");

        out.close();
    }
}