package com.foretruff.http.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpServer {
    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void run() {
        try (var serverSocket = new ServerSocket(port)) {
            var socket = serverSocket.accept();
            processSocket(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) {
        try (socket; // after java 1.8
             var inputStream = new DataInputStream(socket.getInputStream());
             var dataOutputStream = new DataOutputStream(socket.getOutputStream())) {
            //step 1 handle request
            System.out.println("Request: " + new String(inputStream.readNBytes(400)));

            //step 2 handle response
            var body = Files.readAllBytes(Path.of("C:\\Users\\mi200\\IdeaProjects\\DmdevHttp\\photos\\lesson15\\example.html"));
            var headers = String.format("HTTP/1.1 200 OK%ncontent-type: text/html%ncontent-length: %s%n%n", body.length).getBytes();
            dataOutputStream.write(headers);
            dataOutputStream.write(System.lineSeparator().getBytes());
            dataOutputStream.write(body);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
