package com.foretruff.firstAndSecondLeves.socket;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {
        var inetAddress = Inet4Address.getByName("localhost");
        try (var datagramSocket = new DatagramSocket()) {
            // Buffer
            var bytes = "Hello from udp client".getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, inetAddress, 8085);
            datagramSocket.send(packet);
        }

    }
}
