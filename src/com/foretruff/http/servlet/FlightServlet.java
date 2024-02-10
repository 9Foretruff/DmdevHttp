package com.foretruff.http.servlet;

import com.foretruff.http.service.FlightService;
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
        resp.setContentType("text/html; charset=UTF-8");

        var writer = resp.getWriter();
            writer.write("<h1>Список перелетов: </h1>");
            writer.write("<ul>");
            flightService.findAll().forEach(flightDto -> {
                writer.write("""
                        <li>
                        <a href="/tickets?flightId=%d">%s</a>
                        </li>
                        """.formatted(flightDto.getId(),flightDto.getDescription()));
            });
            writer.write("</ul>");

    }
}
