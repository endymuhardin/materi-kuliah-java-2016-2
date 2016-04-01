package com.muhardin.endy.http;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.io.IOException;

@WebFilter("/scopedemo")
public class LoginFilter implements Filter {
	public void init(FilterConfig fc) throws ServletException {
        System.out.println("====== Filter diinisialisasi ======");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse)response;

        String email = (String) req.getSession()
		                .getAttribute("email");

		if(email == null){
			email = req.getParameter("email");
		}

		if(email == null){
			res.sendRedirect("/scope.html");
			return;
		}

		// lanjut ke filter/servlet berikutnya
        fc.doFilter(request, response);

        System.out.println("Mencegat response");
        res.getWriter().println("<br />");
        res.getWriter().println("<em>Ini tambahan response dari filter</em>");

    }

    public void destroy() {
        System.out.println("====== Filter di-destroy ======");
    }
}