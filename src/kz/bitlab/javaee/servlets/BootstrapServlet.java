package kz.bitlab.javaee.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/bootstrap")
public class BootstrapServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.print("<head>");
        out.print("<link rel = 'stylesheet' type = 'text/css' href = '/css/bootstrap.css'>");
        out.print("</head>");
        out.print("<body>");
        out.print("<div class = 'container'>");
        out.print("<nav class=\"navbar navbar-expand-lg bg-dark navbar-dark\">\n" +
                "  <div class=\"container-fluid\">\n" +
                "    <a class=\"navbar-brand\" href=\"#\">Navbar</a>\n" +
                "    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "      <span class=\"navbar-toggler-icon\"></span>\n" +
                "    </button>\n" +
                "    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
                "      <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n" +
                "        <li class=\"nav-item\">\n" +
                "          <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Home</a>\n" +
                "        </li>\n" +
                "        <li class=\"nav-item\">\n" +
                "          <a class=\"nav-link\" href=\"#\">Link</a>\n" +
                "        </li>\n" +
                "        <li class=\"nav-item dropdown\">\n" +
                "          <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n" +
                "            Dropdown\n" +
                "          </a>\n" +
                "          <ul class=\"dropdown-menu\">\n" +
                "            <li><a class=\"dropdown-item\" href=\"#\">Action</a></li>\n" +
                "            <li><a class=\"dropdown-item\" href=\"#\">Another action</a></li>\n" +
                "            <li><hr class=\"dropdown-divider\"></li>\n" +
                "            <li><a class=\"dropdown-item\" href=\"#\">Something else here</a></li>\n" +
                "          </ul>\n" +
                "        </li>\n" +
                "        <li class=\"nav-item\">\n" +
                "          <a class=\"nav-link disabled\">Disabled</a>\n" +
                "        </li>\n" +
                "      </ul>\n" +
                "      <form class=\"d-flex\" role=\"search\">\n" +
                "        <input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n" +
                "        <button class=\"btn btn-outline-light\" type=\"submit\">Search</button>\n" +
                "      </form>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</nav>");
        out.print("</div>");
        out.print("<script src = '/js/bootstrap.bundle.js'></script>");
        out.print("</body>");
        out.print("</html>");
    }
}
