package net.qeema.demo.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.qeema.demo.dto.UserDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DataLoadedServlet extends HttpServlet {
    //HTTP servlet has the methods I will use to serve my HTTP requests

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDTO> userDTOs = (List<UserDTO>)getServletContext().getAttribute("user-list");
        userDTOs.forEach(resp.getWriter()::println);
    }
}
