package net.qeema.demo.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.qeema.demo.dto.UserDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DataLoadedServlet extends HttpServlet {
    //HTTP servlet has the methods I will use to serve my HTTP requests

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //List<UserDTO> userDTOs = (List<UserDTO>)getServletContext().getAttribute("user-list");
        List<UserDTO> userDTOs = (List<UserDTO>)session.getAttribute("user-list");
        session.invalidate(); // a sample of working with sessions.
        userDTOs.forEach(resp.getWriter()::println);
    }
}
