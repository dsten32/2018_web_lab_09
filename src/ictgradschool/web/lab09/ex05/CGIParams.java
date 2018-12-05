package ictgradschool.web.lab09.ex05;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Servlet implementation class CGIParams
 */
public class CGIParams extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CGIParams() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().append("Served at: ").append(request.getContextPath());

        //displayBasic(request, response);

        displayHTML(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pass POST requests through to the same method that processes GET requests
        doGet(request, response);
    }

    private void displayBasic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // http://stackoverflow.com/questions/1928675/servletrequest-getparametermap-returns-mapstring-string-and-servletreques

        // https://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html

        Map<String, String[]> map = request.getParameterMap();
        Iterator<Entry<String, String[]>> i = map.entrySet().iterator();
        response.getWriter().println("\n\nkey: values");

        while(i.hasNext()) {
            Entry<String, String[]> entry = i.next();
            String key = entry.getKey();
            String[] values = entry.getValue();
            response.getWriter().print("\n" + key.toUpperCase() + ": ");
            for(String value: values) {
                response.getWriter().print(value + ",");
            }
        }
        response.getWriter().print("\n");
    }

    private void displayHTML(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // http://stackoverflow.com/questions/1928675/servletrequest-getparametermap-returns-mapstring-string-and-servletreques

        // https://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html

        // "/" is relative to the context root (your web-app name)
        // don't add your web-app name to the path

        //RequestDispatcher view = request.getRequestDispatcher("/response.html"); // works, but /response.jsp causes 500 "jsp support not configured"
        //view.forward(request, response);  


        PrintWriter out = response.getWriter();
        out.println("<html>\n<head><meta charset=\"UTF-8\"><title>Server response</title>");
        out.println("</head>\n<body>");
        out.println("<h1>Server side response</h1>");
        out.println("<p>Thanks for your submission. The values sent to the server are as follows:</p>");


        Map<String, String[]> map = request.getParameterMap();
        Iterator<Entry<String, String[]>> i = map.entrySet().iterator();

        out.println("<table style='border-collapse: collapse'>");

        while(i.hasNext()) {
            Entry<String, String[]> entry = i.next();
            String key = entry.getKey(); //.toUpperCase();
            String[] values = entry.getValue();

            if(key.contains("submit") || key.contains("button")) {
                continue;
            }

            int index = key.indexOf("[]");
            if(index != -1) {
                key = key.substring(0, index);
            }

//            out.print(key + " - ");
            out.print("<tr><td style='border: 1px solid black; padding:10px'>"+key+":</td>");

            for(String value: values) {
//                out.print("&lt;" + value + "&gt; ");
                out.print("<td style='border: 1px solid black; padding:10px'>"+ value +"</td></tr>");
            }

            out.println("<br>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
