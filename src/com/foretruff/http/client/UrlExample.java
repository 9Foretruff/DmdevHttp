package com.foretruff.http.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;

public class UrlExample {
    public static void main(String[] args) throws IOException {
        var url = new URL("file:C:\\Users\\mi200\\IdeaProjects\\DmdevHttp\\src\\com\\foretruff\\http\\socket\\DatagramRunner.java");
        var urlConnection = url.openConnection();

        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
        //OR
        try (FileInputStream inputStream = new FileInputStream(Path.of("C:\\Users\\mi200\\IdeaProjects\\DmdevHttp\\src\\com\\foretruff\\http\\socket\\DatagramRunner.java").toFile())) {
            System.out.println(new String(inputStream.readAllBytes()));
        }
    }

    private static void checkGoogle() throws IOException {
        var url = new URL("https://google.com");
        var urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);

        try (var outputStream = urlConnection.getOutputStream()) {
        }

        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }
}
