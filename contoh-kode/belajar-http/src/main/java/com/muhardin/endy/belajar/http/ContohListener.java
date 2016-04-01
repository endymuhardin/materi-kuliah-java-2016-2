package com.muhardin.endy.http;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.io.IOException;

@WebListener
public class ContohListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
        System.out.println("===== Aplikasi start =====");

        // set nama aplikasi
        sce.getServletContext().setAttribute("aplikasi", "Aplikasi Demo Scope HTTP");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("===== Aplikasi stop =====");
    }
}