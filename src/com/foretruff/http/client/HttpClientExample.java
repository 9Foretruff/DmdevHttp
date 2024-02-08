package com.foretruff.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

import static java.net.http.HttpRequest.BodyPublishers.ofString;
import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.google.com"))
                .GET()
                .build();

        var request2 = HttpRequest.newBuilder()
                .uri(URI.create("https://www.google.com"))
                .POST(ofString("Hello world!"))
                .build();

        var response = httpClient.send(request, ofString(StandardCharsets.UTF_8));
        System.out.println(response.headers());
        System.out.println("--------------");
        System.out.println(response.body());
    }
}
