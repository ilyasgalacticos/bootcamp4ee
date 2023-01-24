package kz.bitlab.javaee.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.javaee.db.model.User;
import kz.bitlab.javaee.db.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/list-users") //endpoint
public class ListUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        ArrayList<User> users = DBUtil.getUsers();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h1>ADD USER</h1>");
        out.print("<form action = '/add-client' method = 'post'>");
        out.print("<span>YOUR NAME : </span><input type = 'text' name = 'user_name'>");
        out.print("<span>YOUR AGE : </span>");
        out.print("<select name = 'user_age'>");
        for(int i=1;i<=100;i++){
            out.print("<option>"+i+"</option>");
        }
        out.print("</select>");
        out.print("<button>SEND</button>");
        out.print("</form>");

        out.print("<hr>");
        out.print("<br>");

        out.print("<table cellpadding = '10' style = 'background-color: lightgrey; border: 1px solid black;'>");
        out.print("<thead>");
        out.print("<tr>");
        out.print("<th>NAME</th>");
        out.print("<th>AGE</th>");
        out.print("</tr>");
        out.print("</thead>");
        out.print("<tbody>");

        for(User user : users){
            out.print("<tr>");
            out.print("<td>"+user.getName()+"</td>");
            out.print("<td>"+user.getAge()+"</td>");
            out.print("</tr>");
        }

        out.print("</tbody>");
        out.print("</table>");

        out.close();
    }
}