package com.example.obspringsecurityjwt.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.security.core.AuthenticationException;
//import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Rechaza  peticiones no autenticadas devolviendo
 * un código de error 401 unauthorized
 */

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {


    private static final Logger log = LoggerFactory.getLogger(JwtAuthEntryPoint.class);


    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        log.error("Unauthorized error: {}", e.getMessage());
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
    }

}
