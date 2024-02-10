package com.foretruff.firstAndSecondLeves.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private final ExecutorService pool;
    private final int port;
    private boolean stopped;

    public HttpServer(int port, int poolSize) {
        this.port = port;
        this.pool = Executors.newFixedThreadPool(poolSize);
    }

    public void run() {
        try (var serverSocket = new ServerSocket(port)) {
            while (!stopped) {
                var socket = serverSocket.accept();
                System.out.println("Socket accepted:");
                pool.submit(() -> processSocket(socket));
            }
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

            Thread.sleep(10000);
            //step 2 handle response
            var body = Files.readAllBytes(Path.of("C:\\Users\\mi200\\IdeaProjects\\DmdevHttp\\photos\\lesson15\\example.html"));
            var headers = String.format("HTTP/1.1 200 OK%ncontent-type: text/html%ncontent-length: %s%n%n", body.length).getBytes();
            dataOutputStream.write(headers);
            dataOutputStream.write(System.lineSeparator().getBytes());
            dataOutputStream.write(body);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
