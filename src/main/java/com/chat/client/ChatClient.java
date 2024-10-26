package com.chat.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 5000;
    
    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Connected to chat server");
            System.out.println("Type your messages (type 'bye' to exit):");
            
            new Thread(() -> {
                try {
                    String serverResponse;
                    while ((serverResponse = in.readLine()) != null) {
                        System.out.println(serverResponse);
                    }
                } catch (IOException e) {
                    System.out.println("Error receiving message: " + e.getMessage());
                }
            }).start();
            
            String message;
            while (true) {
                message = scanner.nextLine();
                out.println(message);
                
                if (message.equalsIgnoreCase("bye")) {
                    break;
                }
            }
            
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
