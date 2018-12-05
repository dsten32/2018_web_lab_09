package ictgradschool.web.lab09.ex01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // request.getParameter accesses parameters from the submitted form
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String bio = request.getParameter("bio");

        // printWriter is used to write to the HTML document
        PrintWriter out = response.getWriter();

        out.println("<p>First Name: " + fname +"</p>");
        out.println("<p> Last Name: " + lname+"</p>");
        out.println();
        out.println("<h1>Biography</h1>");
        out.println(bio);

    }
}
