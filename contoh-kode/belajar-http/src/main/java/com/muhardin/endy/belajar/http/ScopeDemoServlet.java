package com.muhardin.endy.belajar.http;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/scopedemo")
public class ScopeDemoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String aplikasi = (String) getServletContext()
		                .getAttribute("aplikasi");

		String nama = (String) getServletContext()
		                .getAttribute("nama");

		if(nama == null){
			nama = req.getParameter("nama");
			getServletContext().setAttribute("nama", nama);
		}

		String email = (String) req.getSession()
		                .getAttribute("email");

		if(email == null){
			email = req.getParameter("email");
			req.getSession().setAttribute("email", email);
		}

		String hp = req.getParameter("hp");

		res.setContentType("text/html");
		PrintWriter output = res.getWriter();

		output.println("<html>");
		output.println("<head><title>Demo Scope HTTP</title></head>");
		output.println("<body>");
		output.println("<h1>"+aplikasi+"</h1>");
		output.println("<h2>Nama : "+nama+"</h2>");
		output.println("<h2>Email : "+email+"</h2>");
		output.println("<h2>HP : "+hp+"</h2>");
		output.println("<a href=\"/scopedemo\">Reload</a>");
		
		output.println("</body>");
		output.println("</html>");
	}
}