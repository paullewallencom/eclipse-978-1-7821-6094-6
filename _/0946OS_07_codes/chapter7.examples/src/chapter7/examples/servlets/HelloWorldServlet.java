package chapter7.examples.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		java.util.Date currentTime = new java.util.Date();
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>Warm Greeting</title></head>" +
		            "<body>" +
				    "<h1> Hello, World! </h1>" +
		            "<ul> <li>current time: " + currentTime + "</li></ul>" + 
		            "</body></html>"
				);
		pw.close();
	}

}
