package net.qeema.demo.filters;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class AuthFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        String authorName = servletRequest.getServletContext().getInitParameter("author-name");
        log.info("author name is" + authorName);
        if (authorName != null && authorName.equalsIgnoreCase("qeema")) {
            chain.doFilter(servletRequest, servletResponse);
            log.info("you are allowed to register a new user");
        } else {
            servletRequest.getRequestDispatcher("test").forward(servletRequest, servletResponse);
            chain.doFilter(servletRequest, servletResponse);
        }

    }
}
