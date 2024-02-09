package com.foretruff.http.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getHeader("user-agent"));
        var headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            var s = headerNames.nextElement();
            System.out.println(s + ": " + req.getHeader(s));
        }

        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("token","1000");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (var writer = resp.getWriter()) {
            writer.write("<h1>Hello from servlet  Привіт!</h1>");
        }
    }


    //    @Override
//    public void init() throws ServletException {
//        super.init();
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//    }
//
//    @Override
//    public void destroy() {
//        super.destroy();
//    }
}
