package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        // Create session
        HttpSession session = request.getSession();
        session.setAttribute("user", name);

        // Set session expiry to 60 seconds
        session.setMaxInactiveInterval(60);

        out.println("<html><body>");
        out.println("<h2>Hello " + name + "!</h2>");
        out.println("<a href='CheckServlet'>Check Session</a>");
        out.println("</body></html>");
    }
}