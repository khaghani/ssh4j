package com.ssh4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        PrintWriter out = null;

        socket = new Socket("5.39.31.226", 22);
        out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        new Thread(() -> {
            String responseLine;

            try {
                while ((responseLine = in.readLine()) != null) {
                    System.out.println("Server: " + responseLine);

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            out.println(scanner.nextLine());
        }
//        out.close();
//        socket.close();
    }
}
