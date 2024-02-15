package com.foretruff.http.servlet;

import com.foretruff.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.foretruff.http.util.UrlPath.LOGIN;

@WebServlet("/locale")
public class LocaleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newLanguage = req.getParameter("language");
        req.getSession().setAttribute("language", newLanguage);
        var prefPage = req.getHeader("referer");
        var page = prefPage != null ? prefPage : LOGIN;
        String newUrl = page.replaceAll("[?&]language=[^&]*", ""); // Удаляем все параметры language
        if (newUrl.contains("?")) {
            newUrl += "&language=" + newLanguage; // Добавляем новое значение language
        } else {
            newUrl += "?language=" + newLanguage;
        }
        resp.sendRedirect(newUrl);



//        var prefPage = req.getHeader("referer");
//        var page = prefPage != null ? prefPage : LOGIN;
//        resp.sendRedirect(page + "?language=" + language);
    }
}
