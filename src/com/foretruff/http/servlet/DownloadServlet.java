package com.foretruff.http.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Disposition", "attachment; filename=\"filename.txt\"");
        resp.setContentType("application/json; charset=UTF-8");


//        var bytes = Files.readAllBytes(Path.of("C:\\Users\\mi200\\IdeaProjects\\DmdevHttp\\photos\\lesson17\\first.json"));
        try (var outputStream = resp.getOutputStream();
             var resourceAsStream = DownloadServlet.class.getClassLoader().getResourceAsStream("lesson17/first.json")) {
            outputStream.write(resourceAsStream.readAllBytes());
        }
    }
}
