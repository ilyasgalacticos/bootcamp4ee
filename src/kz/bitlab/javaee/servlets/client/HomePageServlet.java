package kz.bitlab.javaee.servlets.client;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.javaee.db.model.City;
import kz.bitlab.javaee.db.model.User;
import kz.bitlab.javaee.db.mysql.DBManager;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/homepage")
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<User> users = DBManager.getAllUsers();
        request.setAttribute("polzovateli", users);

        ArrayList<City> cities = DBManager.getCities();
        request.setAttribute("goroda", cities);

        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
