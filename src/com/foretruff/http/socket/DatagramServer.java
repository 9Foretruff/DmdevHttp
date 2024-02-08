package com.foretruff.http.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class DatagramServer {
    public static void main(String[] args) throws IOException {
        try (var datagramSocket = new DatagramSocket(8085)) {
            byte[] bytes = new byte[512];
            var packet = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(packet);

            System.out.println(new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8));
        }
    }
}
