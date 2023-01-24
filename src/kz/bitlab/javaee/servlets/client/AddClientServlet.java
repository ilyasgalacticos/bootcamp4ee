package kz.bitlab.javaee.servlets.client;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.javaee.db.model.User;
import kz.bitlab.javaee.db.mysql.DBManager;
import kz.bitlab.javaee.db.DBUtil;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/add-client")
public class AddClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> cities = DBUtil.getCities();
        request.setAttribute("goroda", cities);
        request.getRequestDispatcher("/add-client.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("user_name");
        int age = Integer.parseInt(request.getParameter("user_age"));
        String city = request.getParameter("user_city");

        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setCity(city);

        DBManager.addUser(user);

        response.sendRedirect("/add-client?success"); // redirect to other page

    }
}