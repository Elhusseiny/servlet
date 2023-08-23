package net.qeema.demo.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import net.qeema.demo.dto.UserDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

public class UserRegistrationServlet extends HttpServlet {
    //HTTP servlet has the methods I will use to serve my HTTP requests

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("premium" , "true");
        resp.addCookie(cookie);

        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        UserDTO user = UserDTO.builder().name(name).email(email).build();
        //getServletContext().setAttribute("user-list" , List.of(user));
        session.setAttribute("user-list" , List.of(user));
        req.getRequestDispatcher("load").forward(req,resp);



    }
}
