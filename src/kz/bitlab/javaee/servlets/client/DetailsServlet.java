package kz.bitlab.javaee.servlets.client;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.javaee.db.model.User;
import kz.bitlab.javaee.db.DBUtil;
import kz.bitlab.javaee.db.mysql.DBManager;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idshka = request.getParameter("id");
        int id = 0;

        try{
            id = Integer.parseInt(idshka);
        }catch (Exception e){
        }

        User clientUser = DBManager.getUser(id);
        request.setAttribute("user", clientUser);

        ArrayList<String> cities = DBUtil.getCities();
        request.setAttribute("goroda", cities);

        request.getRequestDispatcher("/details.jsp").forward(request, response);
    }
}