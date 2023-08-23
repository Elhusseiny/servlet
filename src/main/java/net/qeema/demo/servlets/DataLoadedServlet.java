package net.qeema.demo.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import net.qeema.demo.dto.UserDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DataLoadedServlet extends HttpServlet {
    //HTTP servlet has the methods I will use to serve my HTTP requests

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String premium  = "false" ;
        try (PrintWriter out = resp.getWriter()) {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++)
                    if (cookies[i].getName().equalsIgnoreCase("premium"))
                        premium = cookies[i].getName() ;

            }
            out.println("user is premium ?" + premium);

            HttpSession session = req.getSession();
            //List<UserDTO> userDTOs = (List<UserDTO>)getServletContext().getAttribute("user-list");
            Object users = session.getAttribute("user-list");
            List<UserDTO> userDTOs = users == null ? null : (List<UserDTO>) session.getAttribute("user-list");
            //List<UserDTO> userDTOs = (List<UserDTO>)session.getAttribute("user-list");
            //session.invalidate(); // a sample of working with sessions.
            if (userDTOs != null) userDTOs.forEach(resp.getWriter()::println);
        }
    }
}
