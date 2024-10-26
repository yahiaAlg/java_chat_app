package com.chat.server;

import java.io.*;
import java.net.*;

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    
    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }
    
    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);
                out.println("Server received: " + message);
                
                if (message.equalsIgnoreCase("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
