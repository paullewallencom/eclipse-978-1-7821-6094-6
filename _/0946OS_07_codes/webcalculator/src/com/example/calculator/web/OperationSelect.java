package com.example.calculator.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/OperationSelect")
public class OperationSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<html><body>");
		pw.write("<h1 allign=\"center\">Web Calculator v1.0</h1>");
		pw.write("<form method=\"POST\" action=\"PerformCalculation.do\">");
		pw.write("<tt>1st operand:</tt> <input type=\"text\" name=\"firstOperand\"><br>");
		pw.write("<tt>2nd operand:</tt> <input type=\"text\" name=\"secondOperand\"><br>");
		pw.write("Operation to be performed: ");
		pw.write("<select name=\"operation\" size=\"1\">");
		pw.write("<option value=\"+\"> + </option>");
		pw.write("<option value=\"-\"> - </option>");
		pw.write("<option value=\"*\"> * </option>");
		pw.write("<option value=\"/\"> / </option>");
		pw.write("</select></br></br>");
		pw.write("<input type=\"submit\" value=\"Submit\">");
		pw.write("</form>");
		pw.write("</body></html>");
		pw.close();
	}

}
