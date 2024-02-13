package com.foretruff.http.servlet;

import com.foretruff.http.service.ImageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {

    private final ImageService imageService = ImageService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var requestUri = req.getRequestURI();
        var imagePath = requestUri.replace("/images", "");

        imageService.get(imagePath).ifPresentOrElse(image -> {
            resp.setContentType("application/octet-stream");
            writeImage(image, resp);
        }, () -> resp.setStatus(404));
    }

    @SneakyThrows
    private void writeImage(InputStream image, HttpServletResponse resp) {
        try (var outputStream = resp.getOutputStream();
             image) {
            int currentByte;
            while ((currentByte = image.read()) != -1) {
                outputStream.write(currentByte);
            }
        }
    }


}