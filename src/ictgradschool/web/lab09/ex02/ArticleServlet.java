package ictgradschool.web.lab09.ex02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ArticleServlet")
public class ArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String aTitle = request.getParameter("aTitle");
        String aAuthor = request.getParameter("aAuthor");
        String aContent = request.getParameter("aContent");
        String aGenre = request.getParameter("aType");

        PrintWriter out = response.getWriter();

        out.println("<h1>"+aTitle+" using POST</h1>");

        out.println("<p> by: "+aAuthor+"</p>");
        out.println("<p> Genre: "+aGenre+"</p>");
        out.println("<p> "+aContent+"</p>");

        out.println("<h2>this is a string array from Java:</h2>");
//        out.println("<br>");

        String[] sArray = {"Four","Three","Two","One"};

        out.println("<ul>");

        for (int i = 0; i < sArray.length; i++) {
            out.println("<li>"+sArray[i]+"</li>");
        }

        out.println("</ul>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String aTitle = request.getParameter("aTitle");
        String aAuthor = request.getParameter("aAuthor");
        String aContent = request.getParameter("aContent");
        String aGenre = request.getParameter("aType");

        PrintWriter out = response.getWriter();

        out.println("<h1>"+aTitle+"</h1>");

        out.println("<p> by: "+aAuthor+"</p>");
        out.println("<p> Genre: "+aGenre+"</p>");
        out.println("<p> "+aContent+"</p>");


    }
}
