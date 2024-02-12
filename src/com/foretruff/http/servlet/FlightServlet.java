package com.foretruff.http.servlet;

import com.foretruff.http.service.FlightService;
import com.foretruff.http.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {
    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("flights", flightService.findAll());
        resp.setContentType("text/html; charset=UTF-8");

        req.getRequestDispatcher(JspHelper.getPath("flights")).forward(req, resp);

    }
}
