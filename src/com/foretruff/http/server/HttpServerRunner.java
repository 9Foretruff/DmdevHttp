package com.foretruff.http.server;

public class HttpServerRunner {
    public static void main(String[] args) {
        var httpServer = new HttpServer(8085, 100);
        httpServer.run();
    }
}
