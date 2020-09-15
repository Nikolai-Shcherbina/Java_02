package ru.geegbrains.java02.lesson_06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        System.out.println("Server started");
        try (ServerSocket serverSocket = new ServerSocket(8189);
             Socket client = serverSocket.accept()) {
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            while (true) {
                String b = in.readUTF();
                out.writeUTF("echo: " + b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

