package net.qeema.demo;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class MyServlet extends HttpServlet {
    //HTTP servlet has the methods I will use to serve my HTTP requests

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String authorName = getServletContext().getInitParameter("author-name");
        String loggedInUser = getServletConfig().getInitParameter("logged-in-user");

        out.println("current logged in user is " + loggedInUser + " and time is " + LocalDateTime.now());
        out.println("author name is " + authorName );
    }
}
