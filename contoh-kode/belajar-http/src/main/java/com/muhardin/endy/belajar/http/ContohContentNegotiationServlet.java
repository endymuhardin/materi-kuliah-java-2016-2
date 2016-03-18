package com.muhardin.endy.belajar.http;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;

import java.util.*;

@WebServlet("/data")
public class ContohContentNegotiationServlet extends HttpServlet {
	private List<Mahasiswa> data = new ArrayList<>();

	public ContohContentNegotiationServlet(){
		for(int i=1; i<11; i++){
			Mahasiswa m = new Mahasiswa();
			m.setNpm("1234567890"+i);
			m.setNama("Mahasiswa "+i);
			data.add(m);
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String contentType = req.getHeader("Accept");
		if(contentType == null){
			res.sendError(400, "Content type harus disebutkan");
		}

		if(contentType.contains("text/html")){
			res.setContentType("text/html");
			PrintWriter output = res.getWriter();
			output.println("<html>");
			output.println("<head>");
			output.println("<title>Data Mahasiswa</title>");
			output.println("</head>");
			output.println("<body>");
			output.println("<h1>Data Mahasiswa</h1>");

			output.println("<table border=1 cellspacing=0 cellpadding=10>");
			output.println("<thead>");
			output.println("<tr><th>NPM</th><th>Nama</th></tr>");
			output.println("</thead>");
			output.println("<tbody>");
			for(Mahasiswa m : data){
				output.println("<tr><td>"+m.getNpm()+"</td><td>"+m.getNama()+"</td></tr>");
			}
			output.println("</tbody>");
			output.println("</table>");

			output.println("</body>");
			output.println("</html>");
			return;
		}

		if(contentType.contains("text/csv")){
			res.setContentType("text/csv");
			res.getWriter().println(konversiDataKeCsv());
			return;
		}
	}

	private String konversiDataKeCsv(){
		StringBuilder hasil = new StringBuilder();

		hasil.append("npm,nama\n");
		for(Mahasiswa m : data){
			hasil.append(m.getNpm()+","+m.getNama()+"\n");
		}

		return hasil.toString();
	}
}