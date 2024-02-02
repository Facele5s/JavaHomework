package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static final int PORT = 25565;

    public String findPhrases(String keyword) {
        try (Socket server = new Socket(InetAddress.getLocalHost(), PORT);
             PrintWriter writer = new PrintWriter(server.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()))) {

            writer.println(keyword);
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
