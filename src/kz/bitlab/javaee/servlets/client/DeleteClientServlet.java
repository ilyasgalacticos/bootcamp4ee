package kz.bitlab.javaee.servlets.client;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.javaee.db.model.User;
import kz.bitlab.javaee.db.mysql.DBManager;

import java.io.IOException;

@WebServlet(value = "/delete-client")
public class DeleteClientServlet extends HttpServlet {
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
            User user = DBManager.getUser(id);
            if (user != null) {
                DBManager.deleteUser(id);
            }
        }
        response.sendRedirect(redirect);
    }
}
