package net.qeema.demo.filters;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        log.info("request is coming from " + servletRequest.getRemoteAddr());
        // you have to continue the chain.
        chain.doFilter(servletRequest, servletResponse);
    }
}
