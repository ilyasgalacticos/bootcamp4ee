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

@WebServlet(value = "/update-client")
public class UpdateClientServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String redirect = "/";
        String idshka = request.getParameter("user_id");
        int id = -1;
        try{
            id = Integer.parseInt(idshka);
        }catch (Exception e){
        }
        if(id != -1) {

            String name = request.getParameter("user_name");
            int age = Integer.parseInt(request.getParameter("user_age"));
            int cityId = Integer.parseInt(request.getParameter("user_city"));

            City city = DBManager.getCity(cityId);

            User user = DBManager.getUser(id);

            if (user != null) {
                user.setName(name);
                user.setCity(city);
                user.setAge(age);
                DBManager.updateUser(user);
                redirect = "/details?id=" + id;
            }
        }
        response.sendRedirect(redirect);
    }
}
