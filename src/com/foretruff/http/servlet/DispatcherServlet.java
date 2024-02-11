package com.foretruff.http.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var requestDispatcher = req.getRequestDispatcher("/flights");
        requestDispatcher.include(req, resp);

        resp.setContentType("text/html; charset=UTF-8");
//        resp.sendRedirect("/flights");
        try (var writer = resp.getWriter()) {
            writer.write("hello!!!"); // нечего не  запишет
            System.out.println("hello");
        }

    }

}
