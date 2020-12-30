package com.example.calculator.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.calculator.model.Calculator;

/**
 * Servlet implementation class ArithmeticExpert
 */
@WebServlet("/PerformCalculation.do")
public class ArithmeticExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<html><body>");
		
		String operandOne = request.getParameter("firstOperand");
		String operandTwo = request.getParameter("secondOperand");
		String operation = request.getParameter("operation");
		
		pw.write("The result of " + 
		   operandOne + " " + 
		   operation + " " + 
		   operandTwo  + 
		   " is " +
		   new Calculator(operandOne, operandTwo,
				   operation).performCalculation());
		
		pw.write("</body></html>");
		pw.close();
		
	}

}
