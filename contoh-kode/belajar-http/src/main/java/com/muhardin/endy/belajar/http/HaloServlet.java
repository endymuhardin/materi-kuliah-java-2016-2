package com.muhardin.endy.belajar.http;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;

@WebServlet("/halo")
public class HaloServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
					throws IOException {

		String nama = req.getParameter("nama");
		String email = req.getParameter("email");

		res.setContentType("text/html");
		
		PrintWriter output = res.getWriter();
		output.println("<html>");
		output.println("<head>");
		output.println("<title>Halo "+nama+"</title>");
		output.println("</head>");
		output.println("<body>");
		output.println("<h1>Halo "+nama+"</h1>");
		output.println("Email : "+email);
		output.println("</body>");
		output.println("</html>");
	}
}