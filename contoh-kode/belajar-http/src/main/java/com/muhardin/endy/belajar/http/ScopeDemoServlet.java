package com.muhardin.endy.belajar.http;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/scopedemo")
public class ScopeDemoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String nama = req.getParameter("nama");

		res.setContentType("text/html");
		PrintWriter output = res.getWriter();

		output.println("<html>");
		output.println("<head><title>Demo Scope HTTP</title></head>");
		output.println("<body>");
		output.println("<h1>Demo Scope Variabel HTTP</h1>");
		output.println("<h2>Nama : "+nama+"</h2>");
		output.println("<a href=\"/scopedemo\">Reload</a>");
		
		output.println("</body>");
		output.println("</html>");
	}
}