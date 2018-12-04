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

        // printWriter is used to write to the HTML document
        PrintWriter out = response.getWriter();

        out.println("First Name: " + fname);
        out.println("Last Name: " + lname);

    }
}
